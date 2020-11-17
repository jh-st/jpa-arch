package com.jh.version2.domain.store;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import org.springframework.util.ObjectUtils;

@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class NotebookDto {

    private Long notebookId;
    private String notebookName;

    @Builder
    public NotebookDto(Notebook notebook) {
        this.notebookId = notebook.getId();
        this.notebookName = notebook.getName();
    }

    public static NotebookDto of (Notebook notebook) {
        if(ObjectUtils.isEmpty(notebook)) return null;

        return NotebookDto.builder().notebook(notebook).build();
    }

}
