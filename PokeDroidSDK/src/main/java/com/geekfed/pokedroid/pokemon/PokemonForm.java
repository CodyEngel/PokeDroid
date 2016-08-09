package com.geekfed.pokedroid.pokemon;

/**
 * Created by cody on 5/13/16.
 */
public class PokemonForm {

    private String mName,
            mFormUrl;

    public PokemonForm(String name, String formUrl) {
        mName = name;
        mFormUrl = formUrl;
    }

    public String getName() {
        return mName;
    }

    public String getFormUrl() {
        return mFormUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PokemonForm that = (PokemonForm) o;

        if (!mName.equals(that.mName)) return false;
        return mFormUrl.equals(that.mFormUrl);

    }

    @Override
    public int hashCode() {
        int result = mName.hashCode();
        result = 31 * result + mFormUrl.hashCode();
        return result;
    }
}
