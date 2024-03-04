package at.fhv.mme.graphs;

import at.fhv.mme.graphs.exceptions.EmptyFileException;
import at.fhv.mme.graphs.exceptions.InvalidFileFormatException;
import at.fhv.mme.graphs.exceptions.NodeAlreadyExistsException;
import at.fhv.mme.graphs.exceptions.NodeNotFoundException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Graph graph = Graph.load("files/example1.txt", GraphType.ADJACENCY_LIST);

            // print structure
            graph.print();
        } catch (IOException e) {
            System.err.println("Error while reading file: " + e.getMessage());
        } catch (EmptyFileException | InvalidFileFormatException | NodeNotFoundException | NodeAlreadyExistsException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}