package ru.mephi.vikingdemo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.mephi.vikingdemo.model.Viking;
import ru.mephi.vikingdemo.service.VikingService;

import java.util.List;

@RestController
@RequestMapping("/api/vikings")
@Tag(name = "Vikings", description = "Операции с викингами")
public class VikingController {

    private final VikingService vikingService;
    private final VikingListener vikingListener;

    public VikingController(VikingService vikingService, VikingListener vikingListener) {
        this.vikingService = vikingService;
        this.vikingListener = vikingListener;
    }

    @GetMapping
    @Operation(summary = "Получить список созданных викингов")
    public List<Viking> getAllVikings() {
        System.out.println("GET /api/vikings called");
        return vikingService.findAll();
    }

    @GetMapping("/test")
    public List<String> test() {
        System.out.println("GET /api/vikings/test called");
        return List.of("Ragnar", "Bjorn");
    }

    @PostMapping("/post")
    public void addViking() {
        vikingListener.testAdd();
    }


    @PostMapping
    @Operation(summary = "Добавить нового викинга (ручной ввод)")
    public void addViking(@RequestBody Viking viking) {
        System.out.println("POST /api/vikings called");
        vikingService.addViking(viking);
       
    }

    @DeleteMapping("/{index}")
    @Operation(summary = "Удалить викинга по индексу")
    public void deleteViking(@PathVariable int index) {
        System.out.println("DELETE /api/vikings/" + index);
        vikingService.deleteViking(index);
    }

    @PutMapping("/{index}")
    @Operation(summary = "Обновить викинга по индексу")
    public void updateViking(@PathVariable int index, @RequestBody Viking viking) {
        System.out.println("PUT /api/vikings/" + index);
        vikingService.updateViking(index, viking);
    }


}
