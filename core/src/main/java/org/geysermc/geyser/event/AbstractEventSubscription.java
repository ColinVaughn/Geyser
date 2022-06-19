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

package org.geysermc.geyser.event;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import net.kyori.event.EventSubscriber;
import org.geysermc.geyser.api.event.*;
import org.geysermc.geyser.api.extension.Extension;

@Getter
@Accessors(fluent = true)
@RequiredArgsConstructor
public abstract class AbstractEventSubscription<T extends Event> implements EventSubscription<T>, EventSubscriber<T> {
    protected final EventBus eventBus;
    protected final Class<T> eventClass;
    protected final EventListener owner;
    protected final Subscribe.PostOrder order;
    @Getter(AccessLevel.NONE) private boolean active;

    @Override
    public boolean isActive() {
        return this.active;
    }

    @Override
    public void unsubscribe() {
        if (!this.active) {
            return;
        }

        this.active = false;
        this.eventBus.unsubscribe(this);
    }

    @Override
    public int postOrder() {
        return this.order.postOrder();
    }
}
