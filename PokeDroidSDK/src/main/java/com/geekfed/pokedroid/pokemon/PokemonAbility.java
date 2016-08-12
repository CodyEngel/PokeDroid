/*
 * Copyright (c) 2016 Cody Engel
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.geekfed.pokedroid.pokemon;

/**
 * Created by cody on 5/13/16.
 */
public class PokemonAbility extends Object {

    private boolean mIsHidden;
    private int mSlot;
    private String mAbilityName,
            mAbilityUrl;

    public PokemonAbility(String abilityName, String abilityUrl, boolean isHidden, int slot) {
        mAbilityName = abilityName;
        mAbilityUrl = abilityUrl;
        mIsHidden = isHidden;
        mSlot = slot;
    }

    public boolean isHidden() {
        return mIsHidden;
    }

    public int getSlot() {
        return mSlot;
    }

    public String getAbilityName() {
        return mAbilityName;
    }

    public String getAbilityUrl() {
        return mAbilityUrl;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;

        if(!((PokemonAbility) obj).getAbilityName().equals(getAbilityName())) return false;
        if(!((PokemonAbility) obj).getAbilityUrl().equals(getAbilityUrl())) return false;
        if(((PokemonAbility) obj).getSlot() != getSlot()) return false;
        if(((PokemonAbility) obj).isHidden() != isHidden()) return false;

        return true;
    }

    // TODO: 5/23/16 need to add the ability to get additional ability info from url, see Ability class
}
