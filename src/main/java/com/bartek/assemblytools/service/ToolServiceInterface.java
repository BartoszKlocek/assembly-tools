package com.bartek.assemblytools.service;

import com.bartek.assemblytools.model.Tool;

import java.util.List;
import java.util.Optional;

public interface ToolServiceInterface {
    List<Tool> getTools();
    Optional<Tool> getToolById(Long id);
    List<Tool> getToolByNumber(String number);
    boolean addTool(Tool tool);
    boolean editTool(Tool editTool);
    boolean editToolProduct(long id, String product);
    boolean removeToolById(long id);
}
