package dev.niemir.Atipera;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Branch {

    private String name;
    private Commit commit;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class Commit{
        String sha;
    }
}
