package Decoder.DecoderList;

import Decoder.Decoder;

import java.util.Iterator;

public class DecoderList implements Iterable<Decoder>{

    private final int capacity = 100;
    private Decoder[] decoders;
    private int currentIndex, insertIndex;
    private DecoderIterator decoderIterator;


    public DecoderList(){
        decoders = new Decoder[capacity];
        insertIndex = 0;
        currentIndex = 0;
    }

    public void add(Decoder decoder) throws Exception {

        try {
            decoders[insertIndex] = decoder;
            insertIndex++;
        }
        catch (ArrayIndexOutOfBoundsException ex){
            throw new Exception("Decoder list full");
        }
    }

    public int getSize(){
        int count = 0;
        for (int i = 0; i < capacity; i++)
            if (decoders[i] != null) count++;
            return count;
    }

    public Decoder get(){
        return decoders[currentIndex];
    }

    public Decoder getNext(){
        Decoder decoder =  decoders[currentIndex];
        currentIndex++;
        return decoder;
    }

    public void reset() {
        this.currentIndex = 0;
    }

    public void setDecoderIterator(DecoderIterator decoderIterator) {
        this.decoderIterator = decoderIterator;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public int getInsertIndex() {
        return insertIndex;
    }

    @Override
    public Iterator<Decoder> iterator() {
        return decoderIterator;
    }

}
