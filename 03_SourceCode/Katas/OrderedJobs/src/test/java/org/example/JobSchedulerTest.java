package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class JobSchedulerTest {
    @Test
    public void itShouldReturnA_GivenA() {
        //arrange
        var sut = new JobScheduler();
        sut.registerJob("A");

        //act
        sut.sort();

        //assert
        assertEquals("A", sut.getList());
    }

    @Test
    public void itShouldReturnAB_GivenAB() {
        //arrange
        var sut = new JobScheduler();
        sut.registerJob("A");
        sut.registerJob("B");

        //act
        sut.sort();

        //assert
        assertEquals("AB", sut.getList());
    }

    @Test
    public void itShouldReturnABC_GivenABC() {
        //arrange
        var sut = new JobScheduler();
        sut.registerJob("A");
        sut.registerJob("B");
        sut.registerJob("C");

        //act
        sut.sort();

        //assert
        assertEquals("ABC", sut.getList());
    }

    @Test
    public void itShouldReturnAB_GivenBDependsOnA() {
        //arrange
        var sut = new JobScheduler();
        sut.registerJob("B", "A");

        //act
        sut.sort();

        //assert
        assertEquals("AB", sut.getList());
    }

    @Test
    public void itShouldReturnABC_GivenCDependsOnB_AndBDependsOnA() {
        //arrange
        var sut = new JobScheduler();
        sut.registerJob("B", "A");
        sut.registerJob("C", "B");

        //act
        sut.sort();

        //assert
        assertEquals("ABC", sut.getList());
    }

    @Test
    public void itShouldReturnAB_GivenABB() {
        //arrange
        var sut = new JobScheduler();
        sut.registerJob("A");
        sut.registerJob("B");
        sut.registerJob("B");

        //act
        sut.sort();

        //assert
        assertEquals("AB", sut.getList());
    }

    @Test
    public void itShouldReturnABC_GivenBDependsOnA_AndCDependsOnB() {
        //arrange
        var sut = new JobScheduler();
        sut.registerJob("C", "B");
        sut.registerJob("B", "A");

        //act
        sut.sort();

        //assert
        assertEquals("ABC", sut.getList());
    }

    @Test
    public void itShouldReturnBA_GivenBA() {
        //arrange
        var sut = new JobScheduler();
        sut.registerJob("B");
        sut.registerJob("A");

        //act
        sut.sort();

        //assert
        assertEquals("BA", sut.getList());
    }

    @Test
    public void ItShouldIgnoreRegisteringIfItResultsInLoop() {
        //arrange
        var sut = new JobScheduler();
        sut.registerJob("B", "A");
        sut.registerJob("C", "B");
        sut.registerJob("A", "C");

        //act
        sut.sort();

        //assert
        assertEquals("ABC", sut.getList());
    }
}