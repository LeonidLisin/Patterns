package ru.geekbrains.patterns.lesson6.beans.decoder.decoderlist;

import lombok.Data;
import org.springframework.stereotype.Component;
import ru.geekbrains.patterns.lesson6.beans.decoder.Decoder;

import java.util.Iterator;

@Data
@Component
public class DecoderList implements Iterable<Decoder> {

    private final DecoderIterator decoderIterator = new DecoderIterator(this);
    private final int capacity = 100;
    private Decoder[] decoders;
    private int currentIndex, insertIndex;

    public DecoderList(){
        decoders = new Decoder[capacity];
        insertIndex = 0;
        currentIndex = 0;
    }

    public void add(Decoder decoder) throws ArrayIndexOutOfBoundsException {

        try {
            decoders[insertIndex] = decoder;
            insertIndex++;
        }
        catch (ArrayIndexOutOfBoundsException ex){
            throw new ArrayIndexOutOfBoundsException("Decoder list full");
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

    @Override
    public Iterator<Decoder> iterator() {
        return decoderIterator;
    }

    private static class DecoderIterator implements Iterator<Decoder>{

        DecoderList decoderList;

        public DecoderIterator (DecoderList decoderList){
            this.decoderList = decoderList;
        }

        @Override
        public boolean hasNext() {
            boolean result = decoderList.getCurrentIndex() != decoderList.getInsertIndex();
            if (!result)
                decoderList.reset();
            return result;
        }

        @Override
        public Decoder next() {
            return decoderList.getNext();
        }

    }

}
