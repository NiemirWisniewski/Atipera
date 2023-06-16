package dev.niemir.Atipera.controller;

import dev.niemir.Atipera.Repositories;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    private String ownerLogin;

    private List<Repositories> repositories;

}
