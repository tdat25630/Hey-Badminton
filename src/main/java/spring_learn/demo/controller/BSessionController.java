package spring_learn.demo.controller;


import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring_learn.demo.Service.BSessionService;
import spring_learn.demo.dto.request.SessionCreationRequest;
import spring_learn.demo.dto.response.ApiResponse;
import spring_learn.demo.dto.response.PageResponse;
import spring_learn.demo.dto.response.SessionResponse;



@RestController
@RequestMapping("/bsession")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class BSessionController {

    private static final Logger log = LoggerFactory.getLogger(BSessionController.class);
    private final BSessionService bSessionService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    ApiResponse<SessionResponse> createSession(@RequestBody SessionCreationRequest request){

        return ApiResponse.<SessionResponse>builder()
                .result(bSessionService.createSession(request))
                .build();
    }

    @GetMapping
    ApiResponse<PageResponse<SessionResponse>> getSessions(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int size){

        Pageable pageable = PageRequest.of(page, size);

        return ApiResponse.<PageResponse<SessionResponse>>builder()
                .result(bSessionService.getSessions(pageable))
                .build();
    }



}
