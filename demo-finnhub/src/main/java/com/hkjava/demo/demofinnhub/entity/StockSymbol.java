package com.hkjava.demo.demofinnhub.entity;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hkjava.demo.demofinnhub.model.Exchange;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "finnhub_exchanges")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StockSymbol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String currency;
    private String description;
    @Column(name = "display_symbol")
    private String displaySymbol;
    @Column(name = "figi_identifier")
    private String figiIdentifier;
    private String isin;
    @Column(name = "primary_exchange_MIC")
    private String primaryExchangeMIC;
    @Column(name = "share_class_FIGI")
    private String shareClassFIGI;
    private String symbol;
    @Column(name = "alternative_ticker")
    private String alternativeTicker;
    @Column(name = "security_type")
    private String securityType;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof StockSymbol))
            return false;
        StockSymbol stockSymbol = (StockSymbol) o;
        return Objects.equals(this.id, stockSymbol.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }
}
