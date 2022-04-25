/*
 * Copyright (c) 2019-2022 GeyserMC. http://geysermc.org
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 * @author GeyserMC
 * @link https://github.com/GeyserMC/Geyser
 */

package org.geysermc.geyser.api.custom.items;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.geysermc.geyser.api.custom.CustomRenderOffsets;

/**
 * This is used to store data for a custom item.
 */
public class CustomItemData {
    private final CustomItemRegistrationTypes registrationType;
    private final String name;

    private String displayName;
    private boolean allowOffhand;
    private int textureSize;

    private CustomRenderOffsets renderOffsets;

    public CustomItemData(@NonNull String name, @NonNull CustomItemRegistrationTypes registrationType) {
        this.registrationType = registrationType;
        this.name = name;

        this.displayName = name;
        this.allowOffhand = false;
        this.textureSize = 16;

        this.renderOffsets = null;
    }

    /**
     * Gets the registration types of the item.
     *
     * @return the registration types of the item.
     */
    public CustomItemRegistrationTypes registrationTypes() {
        return this.registrationType;
    }

    /**
     * Gets the item's name.
     *
     * @return the item's name
     */
    public @NonNull String name() {
        return this.name;
    }

    /**
     * Gets the item's display name. By default, this is the item's name.
     *
     * @return the item's display name
     */
    public @NonNull String displayName() {
        return this.displayName;
    }

    /**
     * Sets the item's display name. By default, this is the item's name.
     *
     * @param displayName the item's display name
     */
    public void displayName(@NonNull String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gets if the item is allowed to be put into the offhand.
     *
     * @return true if the item is allowed to be used in the offhand, false otherwise
     */
    public boolean allowOffhand() {
        return this.allowOffhand;
    }

    /**
     * Sets if the item is allowed to be put into the offhand.
     *
     * @param allowOffhand true if the item is allowed to be used in the offhand, false otherwise
     */
    public void allowOffhand(boolean allowOffhand) {
        this.allowOffhand = allowOffhand;
    }

    /**
     * Gets the item's texture size. This is to resize the item if the texture is not 16x16.
     *
     * @return the item's texture size
     */
    public int textureSize() {
        return this.textureSize;
    }

    /**
     * Sets the item's texture size. This is to resize the item if the texture is not 16x16.
     *
     * @param textureSize the item's texture size
     */
    public void textureSize(int textureSize) {
        this.textureSize = textureSize;
    }

    /**
     * Gets the item's render offsets. If it is null, the item will be rendered normally, with no offsets.
     *
     * @return the item's render offsets
     */
    public @Nullable CustomRenderOffsets renderOffsets() {
        return this.renderOffsets;
    }

    /**
     * Sets the item's render offsets. Set to null to render normally, with no offsets.
     *
     * @param renderOffsets the item's render offsets
     */
    public void renderOffsets(@Nullable CustomRenderOffsets renderOffsets) {
        this.renderOffsets = renderOffsets;
    }
}