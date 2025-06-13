/***********************************************************************************
 * Copyright (c) 2025 Alireza Khodakarami (Jiraiyah)                               *
 * ------------------------------------------------------------------------------- *
 * MIT License                                                                     *
 * =============================================================================== *
 * Permission is hereby granted, free of charge, to any person obtaining a copy    *
 * of this software and associated documentation files (the "Software"), to deal   *
 * in the Software without restriction, including without limitation the rights    *
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell       *
 * copies of the Software, and to permit persons to whom the Software is           *
 * furnished to do so, subject to the following conditions:                        *
 * ------------------------------------------------------------------------------- *
 * The above copyright notice and this permission notice shall be included in all  *
 * copies or substantial portions of the Software.                                 *
 * ------------------------------------------------------------------------------- *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR      *
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,        *
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE     *
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER          *
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,   *
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE   *
 * SOFTWARE.                                                                       *
 ***********************************************************************************/

package jiraiyah.jigui.client.constants;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.utils.BaseHelper;
import jiraiyah.jigui.client.records.TextureData;
import net.minecraft.util.Identifier;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@ModifiedAt("2025-04-23")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
public class SlotIconTextures
{
    public static class Icon
    {
        public static final TextureData BACK =
                new TextureData(0, 0, 0, 0, 16, 16, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/icon/back_slot.png"));
        public static final TextureData BELT =
                new TextureData(0, 0, 0, 0, 16, 16, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/icon/belt_slot.png"));
        public static final TextureData BODY =
                new TextureData(0, 0, 0, 0, 16, 16, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/icon/body_slot.png"));
        public static final TextureData BRACELET =
                new TextureData(0, 0, 0, 0, 16, 16, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/icon/bracelet_slot.png"));
        public static final TextureData CHARM =
                new TextureData(0, 0, 0, 0, 16, 16, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/icon/charm_slot.png"));
        public static final TextureData COSMETIC =
                new TextureData(0, 0, 0, 0, 16, 16, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/icon/cosmetic_slot.png"));
        public static final TextureData CURIO =
                new TextureData(0, 0, 0, 0, 16, 16, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/icon/curio_slot.png"));
        public static final TextureData HANDS =
                new TextureData(0, 0, 0, 0, 16, 16, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/icon/hands_slot.png"));
        public static final TextureData HEAD =
                new TextureData(0, 0, 0, 0, 16, 16, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/icon/head_slot.png"));
        public static final TextureData NECKLACE =
                new TextureData(0, 0, 0, 0, 16, 16, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/icon/necklace_slot.png"));
        public static final TextureData RING =
                new TextureData(0, 0, 0, 0, 16, 16, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/icon/ring_slot.png"));
        public static final TextureData TRASH_CAN =
                new TextureData(0, 0, 0, 0, 16, 16, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/icon/trash_can.png"));

        public static final TextureData BUCKET =
                new TextureData(0, 0, 0, 0, 16, 16, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/icon/bucket.png"));
    }
    
    public static class SlotType
    {
        public static final TextureData AIR =
                new TextureData(0, 0, 0, 0, 16, 16, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/container/air_slot.png"));
        public static final TextureData CROSS =
                new TextureData(0, 0, 0, 0, 16, 16, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/container/delete_slot.png"));
        public static final TextureData DISABLED =
                new TextureData(0, 0, 0, 0, 16, 16, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/container/disabled_slot.png"));
        public static final TextureData FIRE =
                new TextureData(0, 0, 0, 0, 16, 16, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/container/fire_slot.png"));
        public static final TextureData FLUID =
                new TextureData(0, 0, 0, 0, 16, 16, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/container/fluid_slot.png"));
        public static final TextureData BUCKET =
                new TextureData(0, 0, 0, 0, 16, 16, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/container/slot_bucket.png"));
        public static final TextureData ENERGY_UPGRADE =
                new TextureData(0, 0, 0, 0, 16, 16, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/container/slot_energy_upgrade.png"));
        public static final TextureData FLUID_UPGRADE =
                new TextureData(0, 0, 0, 0, 16, 16, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/container/slot_fluid_upgrade.png"));
        public static final TextureData SPEED_UPGRADE =
                new TextureData(0, 0, 0, 0, 16, 16, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/container/slot_speed_upgrade.png"));
        public static final TextureData TOXIC =
                new TextureData(0, 0, 0, 0, 16, 16, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/container/toxic_slot.png"));
        public static final TextureData TRASH =
                new TextureData(0, 0, 0, 0, 16, 16, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/container/trash_slot.png"));
        public static final TextureData TRASH_RED =
                new TextureData(0, 0, 0, 0, 16, 16, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/container/trash_slot_red.png"));
    }
    
    public static class Slot
    {
        public static final TextureData EMPTY_NORMAL =
                new TextureData(0, 0, 0, 0, 16, 16, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/container/slot.png"));
        public static final TextureData EMPTY_HIGHLIGHT_BACK =
                new TextureData(0, 0, 0, 0, 18, 18, 18, 18,
                                Identifier.ofVanilla("textures/gui/sprites/container/slot_highlight_back.png"));
        public static final TextureData EMPTY_HIGHLIGHT_FRONT =
                new TextureData(0, 0, 0, 0, 18, 18, 18, 18,
                                Identifier.ofVanilla("textures/gui/sprites/container/slot_highlight_front.png"));
        public static final TextureData EMPTY_BIG =
                new TextureData(0, 0, 0, 0, 26, 26, 32, 32,
                                BaseHelper.identifier("jigui", "textures/gui/container/slot_large.png"));
    }
}