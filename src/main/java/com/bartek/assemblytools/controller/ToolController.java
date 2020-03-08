package com.bartek.assemblytools.controller;

import com.bartek.assemblytools.model.Tool;
import com.bartek.assemblytools.model.enums.Line;
import com.bartek.assemblytools.model.enums.Status;
import com.bartek.assemblytools.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/tools")
public class ToolController {

    private ToolService toolService;

    @Autowired
    public ToolController(ToolService toolService) {
        this.toolService = toolService;
    }

    @GetMapping
    public String getTools(Model model) {
        model.addAttribute("tools", toolService.getTools());
        return "tool/tools";
    }

    @PostMapping
    public String getToolsSearch(Model model, @RequestParam("toolNumber") String toolNumber) {
        List<Tool> tools = toolService.getTools();

        if (toolNumber != null && !toolNumber.trim().isEmpty()) {
            tools = tools.stream()
                    .filter(t -> t.getToolNumber().contains(toolNumber))
                    .collect(Collectors.toList());
        }

        model.addAttribute("tools", tools);
        return "tool/tools";
    }

    @GetMapping("/add")
    public String getAddTool(Model model) {
        model.addAttribute("tool", new Tool());
        model.addAttribute("statuses", Status.values());
        model.addAttribute("lines", Line.values());
        return "tool/add-tool";
    }

    @PostMapping("/add")
    public String addTool(@ModelAttribute Tool tool) {
        toolService.addTool(tool);
        return "redirect:/tools";
    }

    @GetMapping("delete/{id}")
    public String removeToolById(@PathVariable long id) {
        toolService.removeToolById(id);
        return "redirect:/tools";
    }

    @GetMapping("/edit/{id}")
    public String getToolById(@PathVariable long id, Model model) {
        Optional<Tool> tool = toolService.getToolById(id);
        model.addAttribute("tool", tool.get());
        model.addAttribute("statuses", Status.values());
        model.addAttribute("lines", Line.values());
        return "tool/edit-tool";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Tool tool) {
        toolService.editTool(tool);
        return "redirect:/tools";
    }


}
