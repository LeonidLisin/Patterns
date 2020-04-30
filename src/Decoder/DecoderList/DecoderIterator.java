package Decoder.DecoderList;

import Decoder.Decoder;

import java.util.Iterator;

public class DecoderIterator implements Iterator<Decoder> {

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
