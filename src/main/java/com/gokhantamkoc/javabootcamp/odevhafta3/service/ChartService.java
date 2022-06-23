package com.gokhantamkoc.javabootcamp.odevhafta3.service;

import com.gokhantamkoc.javabootcamp.odevhafta3.model.Candle;
import com.gokhantamkoc.javabootcamp.odevhafta3.repository.CSVRepository;
import com.gokhantamkoc.javabootcamp.odevhafta3.util.chart.CandleStickChart;
import com.gokhantamkoc.javabootcamp.odevhafta3.util.chart.CandlestickChartFactory;
import org.jfree.chart.JFreeChart;

import java.io.IOException;
import java.util.List;

public class ChartService {
	
	CSVRepository cryptoDataCSVRepository;
	
	public ChartService(CSVRepository cryptoDataCSVRepository) {
		this.cryptoDataCSVRepository = cryptoDataCSVRepository;
	}
	
	public CandleStickChart createChartFromCryptoData() {
		// Bu metodu doldurmanizi bekliyoruz.

		List<Candle> candles = null;

		try {
			candles = cryptoDataCSVRepository.readCSV("Binance_BTCUSDT_d.csv");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		CandleStickChart candleStickChart = new CandleStickChart("BTC/USDT Chart");
		for (Candle candle : candles)
		{
			candleStickChart.addCandle(
					candle.getTime(),
					candle.getOpen(),
					candle.getHigh(),
					candle.getLow(),
					candle.getClose(),
					candle.getVolume());
		}

		return candleStickChart;
	}
}
