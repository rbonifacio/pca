package br.unb.cic.algorithms.graph.model;

import br.unb.cic.algorithms.graph.enums.CoresEnum;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Vertex {

    public Vertex(String name) {
        this.name = name;
    }

    String name = "";
    CoresEnum color;
    int timeInit;
    int timeEnd;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CoresEnum getColor() {
        return color;
    }

    public void setColor(CoresEnum color) {
        this.color = color;
    }

    public int getTimeInit() {
        return timeInit;
    }

    public void setTimeInit(int timeInit) {
        this.timeInit = timeInit;
    }

    public int getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(int timeEnd) {
        this.timeEnd = timeEnd;
    }

}
