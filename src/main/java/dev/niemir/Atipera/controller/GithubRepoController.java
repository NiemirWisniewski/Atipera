package dev.niemir.Atipera.controller;

import dev.niemir.Atipera.Branch;
import dev.niemir.Atipera.ErrorMessage;
import dev.niemir.Atipera.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
public class GithubRepoController {

    @GetMapping(value = "/repositories/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getRepositories(
            @PathVariable String username,
            @RequestHeader("Accept") String acceptHeader
    ) {
        if (!acceptHeader.equalsIgnoreCase(MediaType.APPLICATION_JSON_VALUE)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body(new ErrorMessage(HttpStatus.NOT_ACCEPTABLE.value(), "Unsupported media type"));
        }
        try {
            RestTemplate restTemplate = new RestTemplate();
            String apiUrl = "https://api.github.com/users/" + username + "/repos";
            Repositories[] repositories = restTemplate.getForObject(apiUrl, Repositories[].class);
            UserInfo userInfo = new UserInfo();
            userInfo.setOwnerLogin(username);
            userInfo.setRepositories(List.of(repositories));
            for (Repositories rep : repositories
                 ) {
                Branch[] branches = restTemplate.getForObject("https://api.github.com/repos/" + username + "/" + rep.getName() + "/branches", Branch[].class);
                rep.setBranches(List.of(branches));
            }

            return ResponseEntity.ok().body(userInfo);
        } catch (HttpClientErrorException.NotFound ex) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErrorMessage(HttpStatus.NOT_FOUND.value(), "User not found"));
        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage() + "Internal server error"));
        }
    }
}
