package com.jongui.jdk17sample.site.user;

import com.jongui.jdk17sample.persistence.PlayerLogEntity;
import com.jongui.jdk17sample.persistence.UserLogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping()
public class UserLogController {
    @Autowired
    private UserLogService userLogService;
    @Autowired
    private PlayerLogService playerLogService;
    @Autowired
    private UserService userService;
    @Autowired
    private PlayerService playerService;

    @GetMapping("/api/users/log")
    public ResponseEntity<List<LogDto>> getLog(@RequestParam Integer page, @RequestParam Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<UserLogEntity> userLogEntityList = userLogService.findAll(pageable);


        return ResponseEntity.ok().body(userLogEntityList
                .getContent().stream().map(s ->
                        new LogDto(s.getSeq(),s.getUser().getSeq())).collect(Collectors.toList()));

    }

    @GetMapping("/api/users/{seq}")
    public ResponseEntity<Void> getUser(@PathVariable("seq") Integer seq) {
        userService.findById(seq);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/users/all")
    public ResponseEntity<Void> getAllUsers() {
        userService.findAll();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/players/all")
    public ResponseEntity<Void> getAllPlayer() {
        playerService.findAll();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/players/{seq}")
    public ResponseEntity<Void> getPlayer(@PathVariable("seq") Integer seq) {
        playerService.findById(seq);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/api/users/log/all")
    public ResponseEntity<Void> getAllUserLog() {
        List<UserLogEntity> userLogEntityList = userLogService.findAll();
        return ResponseEntity.ok().build();

    }

    @GetMapping("/api/users/log/{seq}")
    public ResponseEntity<Void> getUserBySeq(@PathVariable("seq") Integer seq) {
        UserLogEntity userLogEntityList = userLogService.findById(seq).orElseThrow(() -> new RuntimeException());
        return ResponseEntity.ok().build();

    }

    @GetMapping("/api/players/log")
    public ResponseEntity<List<PlayerLogEntity>> getLog() {
        List<PlayerLogEntity> userLogEntities = playerLogService.getAll();
        return ResponseEntity.ok().build();
    }

}
