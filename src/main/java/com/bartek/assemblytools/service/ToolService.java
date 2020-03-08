package com.bartek.assemblytools.service;

import com.bartek.assemblytools.model.Tool;
import com.bartek.assemblytools.model.enums.Line;
import com.bartek.assemblytools.model.enums.Status;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ToolService implements ToolServiceInterface {

    private List<Tool> toolList;

    public ToolService() {
        this.toolList = new ArrayList<>();

        toolList.add(new Tool(1, "VM10543/23/A", Status.MODIFICATION, Line.COOPERATION, "Drive", "Kowalsky", "komentarz"));
        toolList.add(new Tool(2, "VM10612/25/B", Status.NITRIFICATION, Line.COOPERATION, "Chain Hoist", "Nowak", "komentarz..."));
        toolList.add(new Tool(3, "VM10543/23/G", Status.OK, Line.L1, "MOTOR", "Neuer", "komentarz..."));
        toolList.add(new Tool(4, "VM12222/88/D", Status.OK, Line.L1, "MOTOR", "Braun", "komenatarz"));

    }

    @Override
    public List<Tool> getTools() {
        return toolList;
    }

    @Override
    public Optional<Tool> getToolById(Long id) {
        return toolList.stream().filter(tool -> tool.getId() == id).findFirst();
    }

    @Override
    public List<Tool> getToolByNumber(String number) {
        return toolList.stream().filter(tool -> tool.getToolNumber().contains(number)).collect(Collectors.toList());
    }

    @Override
    public boolean addTool(Tool tool) {
        tool.setId(toolList.get(toolList.size() - 1).getId() + 1);
        tool.setDateOfTransfer(LocalDate.now());
        return toolList.add(tool);
    }

    @Override
    public boolean editTool(Tool editTool) {
        Optional<Tool> first = toolList.stream().filter(tool -> tool.getId() == editTool.getId()).findFirst();
        if (first.isPresent()){
            Tool tool = first.get();
            int index = toolList.indexOf(tool);
            toolList.set(index,editTool);
            editTool.setDateOfTransfer(LocalDate.now());
            return true;
        }
        return true;
    }

    @Override
    public boolean editToolProduct(long id, String product) {
        Optional<Tool> first = toolList.stream().filter(tool -> tool.getId() == id).findFirst();
        if (first.isPresent()) {
            Tool tool = first.get();
            tool.setProduct(product);
            return true;
        }

        return
                false;
    }

    @Override
    public boolean removeToolById(long id) {
        Optional<Tool> first = toolList.stream().filter(tool -> tool.getId() == id).findFirst();
        if (first.isPresent()) {
            toolList.remove(first.get());
            return true;
        }
        return true;

    }
}
