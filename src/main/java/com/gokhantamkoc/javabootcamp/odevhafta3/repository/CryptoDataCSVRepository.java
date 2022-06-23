package com.gokhantamkoc.javabootcamp.odevhafta3.repository;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import com.gokhantamkoc.javabootcamp.odevhafta3.model.Candle;

import static com.gokhantamkoc.javabootcamp.odevhafta3.util.TimeUtils.convertToMillisTime;

public class CryptoDataCSVRepository implements CSVRepository {

    private final String COMMA_DELIMITER = ",";
    private BufferedReader fin;

    @Override
    public List<Candle> readCSV(String filename) throws FileNotFoundException, IOException {
        List<Candle> candles = new ArrayList<Candle>();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filename);
        // Bu alandan itibaren kodunuzu yazabilirsiniz

        this.fin = new BufferedReader(new InputStreamReader(inputStream));
        fin.readLine();

        while (true){
            String line = getline();
            if(line == null) break;
            candles.add(getCandle(line));
        }

        // Bu alandan sonra kalan kod'a dokunmayiniz.
        return candles;
    }

    public String getline() throws IOException {
        return fin.readLine();
    }

    public Candle getCandle(String line) {
        String[] lineArray = line.split(COMMA_DELIMITER);

        Candle candle = new Candle(
                Long.parseLong(lineArray[0]),
                Double.parseDouble(lineArray[3]),
                Double.parseDouble(lineArray[4]),
                Double.parseDouble(lineArray[5]),
                Double.parseDouble(lineArray[6]),
                Double.parseDouble(lineArray[7])
        );
        return candle;
    }
}
