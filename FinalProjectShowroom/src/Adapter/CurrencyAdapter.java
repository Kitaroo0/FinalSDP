package Adapter;
public class CurrencyAdapter implements AdapterCurrency {
    private Currency currency;

    public CurrencyAdapter(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String getAdapterCurrency() {
        return currency.getCurrency();
    }
}