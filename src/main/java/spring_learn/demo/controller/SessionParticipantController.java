package spring_learn.demo.controller;


import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import spring_learn.demo.Service.SessionParticipantService;
import spring_learn.demo.dto.request.SessionParticipantRequest;
import spring_learn.demo.dto.response.ApiResponse;
import spring_learn.demo.dto.response.PageResponse;
import spring_learn.demo.dto.response.SessionParticipantResponse;




@RestController
@RequiredArgsConstructor
@RequestMapping("/sessionParticipants")
@SecurityRequirement(name = "bearerAuth")
public class SessionParticipantController {
    private static final Logger log = LoggerFactory.getLogger(SessionParticipantController.class);
    private final SessionParticipantService sessionParticipantService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    ApiResponse<SessionParticipantResponse> createSessionParticipant(@RequestBody SessionParticipantRequest request){

        return ApiResponse.<SessionParticipantResponse>builder()
                .result(sessionParticipantService.createSessionParticipant(request))
                .build();
    }

    @PostMapping("/addGuess")
    @PreAuthorize("hasRole('ADMIN')")
    ApiResponse<SessionParticipantResponse> addGuessToSession(@RequestBody SessionParticipantRequest request){

        return ApiResponse.<SessionParticipantResponse>builder()
                .result(sessionParticipantService.addGuessToSession(request))
                .build();
    }

    @GetMapping
    ApiResponse<PageResponse<SessionParticipantResponse>> getSessionParticipants(@RequestParam String sessionId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){

        Pageable pageable = PageRequest.of(page, size);

        return ApiResponse.<PageResponse<SessionParticipantResponse>>builder()
                .result(sessionParticipantService.getAllSessionParticipantsBySessionId(sessionId,pageable))
                .build();


    }

}
