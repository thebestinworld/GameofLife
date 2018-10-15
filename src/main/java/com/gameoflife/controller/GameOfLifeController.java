package com.gameoflife.controller;


import com.gameoflife.dto.BoardDTO;
import com.gameoflife.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class GameOfLifeController {



    @PutMapping(value = "/nextGeneration", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity nextGeneration(@RequestBody BoardDTO boardDTO) {
        Board board = new Board(boardDTO.getBoard(),boardDTO.getGeneration()).doNext();
        boardDTO.setBoard(board.toBoolean());
        return ResponseEntity.ok(boardDTO);
    }

    @PutMapping(value = "/randomBoard", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity randomBoard(@RequestBody BoardDTO boardDTO) {
        Board board = new Board(25,30,0);
        boardDTO.setBoard(board.toBoolean());
        return ResponseEntity.ok(boardDTO);
    }



}
