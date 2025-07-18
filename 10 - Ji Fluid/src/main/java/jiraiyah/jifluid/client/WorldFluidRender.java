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

package jiraiyah.jifluid.client;

import jiraiyah.jibase.enumerations.ColorMode;
import net.fabricmc.fabric.api.transfer.v1.client.fluid.FluidVariantRendering;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariantAttributes;
import net.fabricmc.fabric.api.transfer.v1.fluid.base.SingleFluidStorage;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class WorldFluidRender
{
    public void render(@Nullable SingleFluidStorage storage, VertexConsumerProvider vertexConsumers, MatrixStack matrices, int light, int overlay,
                       World world, BlockPos pos,
                       float x1, float y1, float z1,
                       float x2, float maxHeight, float z2)
    {
        render(storage, vertexConsumers, matrices, light, overlay, world, pos, x1, y1, z1, x2, maxHeight, z2, 0xFFFFFFFF, ColorMode.MULTIPLICATION, false);
    }

    public void render(@Nullable SingleFluidStorage storage, VertexConsumerProvider vertexConsumers, MatrixStack matrices, int light, int overlay,
                       World world, BlockPos pos,
                       float x1, float y1, float z1,
                       float x2, float maxHeight, float z2,
                       int color, ColorMode colorMode)
    {
        render(storage, vertexConsumers, matrices, light, overlay, world, pos, x1, y1, z1, x2, maxHeight, z2, color, colorMode, false);
    }

    public void render(@Nullable SingleFluidStorage storage, VertexConsumerProvider vertexConsumers, MatrixStack matrices, int light, int overlay,
                       World world, BlockPos pos,
                       float x1, float y1, float z1,
                       float x2, float maxHeight, float z2, boolean debug)
    {
        render(storage, vertexConsumers, matrices, light, overlay, world, pos, x1, y1, z1, x2, maxHeight, z2, 0xFFFFFFFF, ColorMode.MULTIPLICATION, debug);
    }

    public void render(@Nullable SingleFluidStorage storage, VertexConsumerProvider vertexConsumers, MatrixStack matrices, int light, int overlay,
                       World world, BlockPos pos,
                       float x1, float y1, float z1,
                       float x2, float maxHeight, float z2,
                       int color, ColorMode colorMode, boolean debug)
    {
        if (storage == null || storage.isResourceBlank() || storage.amount <= 0)
            return;

        FluidVariant fluidVariant = storage.getResource();
        long amount = storage.amount;
        long capacity = storage.getCapacity();
        float fillPercentage = (float) amount / capacity;

        if(debug)
            fillPercentage = (float) (Math.sin(world.getTime() / 64.0) * 0.5 + 0.5);

        int fluidColor = FluidVariantRendering.getColor(fluidVariant, world, pos);
        fluidColor = ColorMode.modifyColor(fluidColor, color, colorMode);

        Sprite stillSprite = FluidVariantRendering.getSprite(fluidVariant);
        if(stillSprite == null)
            return;

        RenderLayer renderLayer = RenderLayer.getItemEntityTranslucentCull(stillSprite.getAtlasId());
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(renderLayer);

        float y2 = ((fillPercentage * maxHeight) / 16f) + y1;

        matrices.push();

            //matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180));

            if (!FluidVariantAttributes.isLighterThanAir(fluidVariant))
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180));

            MatrixStack.Entry entry = matrices.peek();

            int blockLight = (light >> 4) & 0xF;
            int luminosity = Math.max(blockLight, FluidVariantAttributes.getLuminance(fluidVariant));
            light = (light & 0xF00000) | (luminosity << 4);

            // Front (XY plane, z constant)
            drawTiledXYQuad(vertexConsumer, entry,
                            x1, y1, z1 + 0.001F,
                            x2, y2, z1 + 0.001F,
                            stillSprite, fluidColor, light, overlay, 0.0F, 1.0F, -1.0F);

            // Back (XY plane, z constant)
            drawReversedTiledXYQuad(vertexConsumer, entry,
                                    x1, y1, z2 - 0.001F,
                                    x2, y2, z2 - 0.001F,
                                    stillSprite, fluidColor, light, overlay, 0.0F, 1.0F, 1.0F);

            // Left (YZ plane, x constant)
            drawReversedTiledYZQuad(vertexConsumer, entry,
                                    x1 + 0.001F, y1, z1,
                                    y2, z2,
                                    stillSprite, fluidColor, light, overlay, 1.0F, 1.0F, 0.0F);

            // Right (YZ plane, x constant)
            drawTiledYZQuad(vertexConsumer, entry,
                            x2 - 0.001F, y1, z1,
                            y2, z2,
                            stillSprite, fluidColor, light, overlay, -1.0F, 1.0F, 0.0F);

            if (fillPercentage < 1.0F)
                drawTiledTopQuad(vertexConsumer, entry, x1, y2, z1 + 0.001F, x2, z2 - 0.001F, stillSprite, fluidColor, light, overlay);

        matrices.pop();
    }

    public void renderTopFaceOnly(@Nullable SingleFluidStorage storage, VertexConsumerProvider vertexConsumers, MatrixStack matrices, int light, int overlay,
                                  World world, BlockPos pos,
                                  float x1, float y, float z1,
                                  float x2, float z2)
    {
        renderTopFaceOnly(storage, vertexConsumers, matrices, light, overlay, world, pos, x1, y, z1, x2, z2, 0xFFFFFFFF, ColorMode.MULTIPLICATION);
    }

    public void renderTopFaceOnly(@Nullable SingleFluidStorage storage, VertexConsumerProvider vertexConsumers, MatrixStack matrices, int light, int overlay,
                                  World world, BlockPos pos,
                                  float x1, float y, float z1,
                                  float x2, float z2,
                                  int color, ColorMode colorMode)
    {
        if(storage == null || storage.isResourceBlank() || storage.amount <= 0)
            return;

        FluidVariant fluidVariant = storage.getResource();

        if(fluidVariant == null)
            return;

        int fluidColor = FluidVariantRendering.getColor(fluidVariant, world, pos);
        fluidColor = ColorMode.modifyColor(fluidColor, color, colorMode);

        Sprite stillSprite = FluidVariantRendering.getSprite(fluidVariant);
        if(stillSprite == null)
            return;

        RenderLayer renderLayer = RenderLayer.getItemEntityTranslucentCull(stillSprite.getAtlasId());
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(renderLayer);

        matrices.push();

            //matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180));

            if (!FluidVariantAttributes.isLighterThanAir(fluidVariant))
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180));

            MatrixStack.Entry entry = matrices.peek();

            int blockLight = (light >> 4) & 0xF;
            int luminosity = Math.max(blockLight, FluidVariantAttributes.getLuminance(fluidVariant));
            light = (light & 0xF00000) | (luminosity << 4);

            drawTiledTopQuad(vertexConsumer, entry, x1, y, z1 + 0.001F, x2, z2 - 0.001F, stillSprite, fluidColor, light, overlay);

        matrices.pop();
    }

    public static void drawTiledTopQuad(VertexConsumer vertexConsumer,
                                        MatrixStack.Entry entry,
                                        float x1, float y, float z1,
                                        float x2, float z2,
                                        Sprite sprite,
                                        int color, int light, int overlay)
    {
        //float tileSize = 1.0f; // Maximum tile size in world space
        int tileCountX = Math.max(1, Math.round((x2 - x1)));// / tileSize));
        int tileCountZ = Math.max(1, Math.round((z2 - z1)));// / tileSize));

        float tileWidth = (x2 - x1) / tileCountX;
        float tileDepth = (z2 - z1) / tileCountZ;

        float u0 = sprite.getMinU();
        float v0 = sprite.getMinV();
        float u1 = sprite.getMaxU();
        float v1 = sprite.getMaxV();

        float tileUSize = (u1 - u0);
        float tileVSize = (v1 - v0);

        for (int i = 0; i < tileCountX; i++) {
            for (int j = 0; j < tileCountZ; j++) {
                float xStart = x1 + i * tileWidth;
                float xEnd = xStart + tileWidth;
                float zStart = z1 + j * tileDepth;
                float zEnd = zStart + tileDepth;

                float uEnd = u0 + tileUSize;
                float vEnd = v0 + tileVSize;

                vertexConsumer.vertex(entry, xStart, y, zStart)
                              .color(color)
                              .texture(u0, v0)
                              .light(light)
                              .overlay(overlay)
                              .normal(0.0F, 1.0F, 0.0F);

                vertexConsumer.vertex(entry, xStart, y, zEnd)
                              .color(color)
                              .texture(u0, vEnd)
                              .light(light)
                              .overlay(overlay)
                              .normal(0.0F, 1.0F, 0.0F);

                vertexConsumer.vertex(entry, xEnd, y, zEnd)
                              .color(color)
                              .texture(uEnd, vEnd)
                              .light(light)
                              .overlay(overlay)
                              .normal(0.0F, 1.0F, 0.0F);

                vertexConsumer.vertex(entry, xEnd, y, zStart)
                              .color(color)
                              .texture(uEnd, v0)
                              .light(light)
                              .overlay(overlay)
                              .normal(entry, 0.0F, 1.0F, 0.0F);
            }
        }
    }

    public void drawTiledXYQuadOnly(@Nullable SingleFluidStorage storage, VertexConsumerProvider vertexConsumers, MatrixStack matrices, int light, int overlay,
                                    World world, BlockPos pos,
                                    float x1, float y1, float z1,
                                    float x2, float y2, float z2)
    {
        drawTiledXYQuadOnly(storage, vertexConsumers, matrices, light, overlay, world, pos, x1, y1, z1, x2, y2, z2, 0xFFFFFFFF, ColorMode.MULTIPLICATION);
    }

    public void drawTiledXYQuadOnly(@Nullable SingleFluidStorage storage, VertexConsumerProvider vertexConsumers, MatrixStack matrices, int light, int overlay,
                                    World world, BlockPos pos,
                                    float x1, float y1, float z1,
                                    float x2, float y2, float z2,
                                    int color, ColorMode colorMode)
    {
        if(storage == null || storage.isResourceBlank() || storage.amount <= 0)
            return;

        FluidVariant fluidVariant = storage.getResource();

        if (fluidVariant == null)
            return;

        int fluidColor = FluidVariantRendering.getColor(fluidVariant, world, pos);
        fluidColor = ColorMode.modifyColor(fluidColor, color, colorMode);

        Sprite stillSprite = FluidVariantRendering.getSprite(fluidVariant);
        if(stillSprite == null)
            return;

        RenderLayer renderLayer = RenderLayer.getItemEntityTranslucentCull(stillSprite.getAtlasId());
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(renderLayer);

        matrices.push();

            //matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180));

            if (!FluidVariantAttributes.isLighterThanAir(fluidVariant))
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180));

            MatrixStack.Entry entry = matrices.peek();

            int blockLight = (light >> 4) & 0xF;
            int luminosity = Math.max(blockLight, FluidVariantAttributes.getLuminance(fluidVariant));
            light = (light & 0xF00000) | (luminosity << 4);

            drawTiledXYQuad(vertexConsumer, entry, x1, y1, z1, x2, y2, z2, stillSprite, fluidColor, light, overlay, 0.0F, 1.0F, -1.0F);

        matrices.pop();
    }

    public static void drawTiledXYQuad(VertexConsumer vertexConsumer,
                                       MatrixStack.Entry entry,
                                       float x1, float y1, float z1,
                                       float x2, float y2, float z2,
                                       Sprite sprite,
                                       int color,
                                       int light, int overlay,
                                       float nx, float ny, float nz)
    {
        float tileSize = 1.0f;
        int fullTilesX = (int) ((x2 - x1));// / tileSize);
        int fullTilesY = (int) ((y2 - y1));// / tileSize);
        float leftoverX = (x2 - x1) - (fullTilesX);// * tileSize);
        float leftoverY = (y2 - y1) - (fullTilesY);// * tileSize);

        // Draw full tiles
        for (int i = 0; i < fullTilesX; i++) {
            for (int j = 0; j < fullTilesY; j++) {
                float xStart = x1 + i;// * tileSize;
                float xEnd = xStart + tileSize;
                float yStart = y1 + j;// * tileSize;
                float yEnd = yStart + tileSize;
                float u0 = sprite.getMinU();
                float v0 = sprite.getMinV();
                float u1 = sprite.getMaxU();
                float v1 = sprite.getMaxV();
                drawQuad(vertexConsumer, entry, xStart, yStart, z1, xEnd, yEnd, z2, u0, v0, u1, v1, color, light, overlay, nx, ny, nz);
            }
        }

        // Draw leftover tiles in x
        if (leftoverX > 0) {
            for (int j = 0; j < fullTilesY; j++) {
                float xStart = x1 + fullTilesX;// * tileSize;
                float xEnd = xStart + leftoverX;
                float yStart = y1 + j;// * tileSize;
                float yEnd = yStart + tileSize;
                float u0 = sprite.getMinU();
                float v0 = sprite.getMinV();
                float u1 = sprite.getFrameU(leftoverX);
                float v1 = sprite.getFrameV(tileSize);
                drawQuad(vertexConsumer, entry, xStart, yStart, z1, xEnd, yEnd, z2, u0, v0, u1, v1, color, light, overlay, nx, ny, nz);
            }
        }

        // Draw leftover tiles in y
        if (leftoverY > 0) {
            for (int i = 0; i < fullTilesX; i++) {
                float xStart = x1 + i;// * tileSize;
                float xEnd = xStart + tileSize;
                float yStart = y1 + fullTilesY;// * tileSize;
                float yEnd = yStart + leftoverY;
                float u0 = sprite.getMinU();
                float v0 = sprite.getMinV();
                float u1 = sprite.getFrameU(tileSize);
                float v1 = sprite.getFrameV(leftoverY);
                drawQuad(vertexConsumer, entry, xStart, yStart, z1, xEnd, yEnd, z2, u0, v0, u1, v1, color, light, overlay, nx, ny, nz);
            }

            // Draw the corner leftover tile if both leftoverX and leftoverY > 0
            if (leftoverX > 0) {
                float xStart = x1 + fullTilesX;// * tileSize;
                float xEnd = xStart + leftoverX;
                float yStart = y1 + fullTilesY;// * tileSize;
                float yEnd = yStart + leftoverY;
                float u0 = sprite.getMinU();
                float v0 = sprite.getMinV();
                float u1 = sprite.getFrameU(leftoverX);
                float v1 = sprite.getFrameV(leftoverY);
                drawQuad(vertexConsumer, entry, xStart, yStart, z1, xEnd, yEnd, z2, u0, v0, u1, v1, color, light, overlay, nx, ny, nz);
            }
        }
    }

    public static void drawTiledYZQuad(VertexConsumer vertexConsumer,
                                       MatrixStack.Entry entry,
                                       float x, float y1, float z1,
                                       float y2, float z2,
                                       Sprite sprite,
                                       int color,
                                       int light, int overlay,
                                       float nx, float ny, float nz)
    {
        float tileSize = 1.0f;
        int fullTilesZ = (int) ((z2 - z1));// / tileSize);
        int fullTilesY = (int) ((y2 - y1));// / tileSize);
        float leftoverZ = (z2 - z1) - (fullTilesZ);// * tileSize);
        float leftoverY = (y2 - y1) - (fullTilesY);// * tileSize);

        // Draw full tiles
        for (int i = 0; i < fullTilesZ; i++) {
            for (int j = 0; j < fullTilesY; j++) {
                float zStart = z1 + i;// * tileSize;
                float zEnd = zStart + tileSize;
                float yStart = y1 + j;// * tileSize;
                float yEnd = yStart + tileSize;
                float u0 = sprite.getMinU();
                float v0 = sprite.getMinV();
                float u1 = sprite.getMaxU();
                float v1 = sprite.getMaxV();
                drawQuad(vertexConsumer, entry, x, yStart, zStart, x, yEnd, zEnd, u0, v0, u1, v1, color, light, overlay, nx, ny, nz);
            }
        }

        // Draw leftover tiles in z
        if (leftoverZ > 0) {
            for (int j = 0; j < fullTilesY; j++) {
                float zStart = z1 + fullTilesZ;// * tileSize;
                float zEnd = zStart + leftoverZ;
                float yStart = y1 + j;// * tileSize;
                float yEnd = yStart + tileSize;
                float u0 = sprite.getMinU();
                float v0 = sprite.getMinV();
                float u1 = sprite.getFrameU(leftoverZ);
                float v1 = sprite.getFrameV(tileSize);
                drawQuad(vertexConsumer, entry, x, yStart, zStart, x, yEnd, zEnd, u0, v0, u1, v1, color, light, overlay, nx, ny, nz);
            }
        }

        // Draw leftover tiles in y
        if (leftoverY > 0) {
            for (int i = 0; i < fullTilesZ; i++) {
                float zStart = z1 + i;// * tileSize;
                float zEnd = zStart + tileSize;
                float yStart = y1 + fullTilesY;// * tileSize;
                float yEnd = yStart + leftoverY;
                float u0 = sprite.getMinU();
                float v0 = sprite.getMinV();
                float u1 = sprite.getFrameU(tileSize);
                float v1 = sprite.getFrameV(leftoverY);
                drawQuad(vertexConsumer, entry, x, yStart, zStart, x, yEnd, zEnd, u0, v0, u1, v1, color, light, overlay, nx, ny, nz);
            }

            // Draw the corner leftover tile if both leftoverZ and leftoverY > 0
            if (leftoverZ > 0) {
                float zStart = z1 + fullTilesZ;// * tileSize;
                float zEnd = zStart + leftoverZ;
                float yStart = y1 + fullTilesY;// * tileSize;
                float yEnd = yStart + leftoverY;
                float u0 = sprite.getMinU();
                float v0 = sprite.getMinV();
                float u1 = sprite.getFrameU(leftoverZ);
                float v1 = sprite.getFrameV(leftoverY);
                drawQuad(vertexConsumer, entry, x, yStart, zStart, x, yEnd, zEnd, u0, v0, u1, v1, color, light, overlay, nx, ny, nz);
            }
        }
    }

    private static void drawQuad(VertexConsumer vertexConsumer,
                                 MatrixStack.Entry entry,
                                 float x1, float y1, float z1,
                                 float x2, float y2, float z2,
                                 float minU, float minV,
                                 float maxU, float maxV,
                                 int color,
                                 int light, int overlay,
                                 float normalX, float normalY, float normalZ)
    {
        vertexConsumer.vertex(entry, x1, y1, z1)
                      .color(color)
                      .texture(minU, minV)
                      .light(light)
                      .overlay(overlay)
                      .normal(normalX, normalY, normalZ);

        vertexConsumer.vertex(entry, x1, y2, z1)
                      .color(color)
                      .texture(minU, maxV)
                      .light(light)
                      .overlay(overlay)
                      .normal(normalX, normalY, normalZ);

        vertexConsumer.vertex(entry, x2, y2, z2)
                      .color(color)
                      .texture(maxU, maxV)
                      .light(light)
                      .overlay(overlay)
                      .normal(normalX, normalY, normalZ);

        vertexConsumer.vertex(entry, x2, y1, z2)
                      .color(color)
                      .texture(maxU, minV)
                      .light(light)
                      .overlay(overlay)
                      .normal(normalX, normalY, normalZ);
    }

    private static void drawReversedQuad(VertexConsumer vertexConsumer,
                                         MatrixStack.Entry entry,
                                         float x1, float y1, float z1,
                                         float x2, float y2, float z2,
                                         float minU, float minV,
                                         float maxU, float maxV,
                                         int color,
                                         int light, int overlay,
                                         float normalX, float normalY, float normalZ)
    {
        // Vertex 4: (x2, y1, z2) with (maxU, minV)
        vertexConsumer.vertex(entry, x2, y1, z2).color(color).texture(maxU, minV).light(light).overlay(overlay).normal(normalX, normalY, normalZ);
        // Vertex 3: (x2, y2, z2) with (maxU, maxV)
        vertexConsumer.vertex(entry, x2, y2, z2).color(color).texture(maxU, maxV).light(light).overlay(overlay).normal(normalX, normalY, normalZ);
        // Vertex 2: (x1, y2, z1) with (minU, maxV)
        vertexConsumer.vertex(entry, x1, y2, z1).color(color).texture(minU, maxV).light(light).overlay(overlay).normal(normalX, normalY, normalZ);
        // Vertex 1: (x1, y1, z1) with (minU, minV)
        vertexConsumer.vertex(entry, x1, y1, z1).color(color).texture(minU, minV).light(light).overlay(overlay).normal(normalX, normalY, normalZ);
    }

    private static void drawReversedTiledXYQuad(VertexConsumer vertexConsumer,
                                                MatrixStack.Entry entry,
                                                float x1, float y1, float z1,
                                                float x2, float y2, float z2,
                                                Sprite sprite,
                                                int color,
                                                int light, int overlay,
                                                float nx, float ny, float nz) {
        float tileSize = 1.0f;
        int fullTilesX = (int) ((x2 - x1));// / tileSize);
        int fullTilesY = (int) ((y2 - y1));// / tileSize);
        float leftoverX = (x2 - x1) - (fullTilesX);// * tileSize);
        float leftoverY = (y2 - y1) - (fullTilesY);// * tileSize);

        // Draw full tiles
        for (int i = 0; i < fullTilesX; i++) {
            for (int j = 0; j < fullTilesY; j++) {
                float xStart = x1 + i;// * tileSize;
                float xEnd = xStart + tileSize;
                float yStart = y1 + j;// * tileSize;
                float yEnd = yStart + tileSize;
                float u0 = sprite.getMinU();
                float v0 = sprite.getMinV();
                float u1 = sprite.getMaxU();
                float v1 = sprite.getMaxV();
                drawReversedQuad(vertexConsumer, entry, xStart, yStart, z1, xEnd, yEnd, z2, u0, v0, u1, v1, color, light, overlay, nx, ny, nz);
            }
        }

        // Draw leftover tiles in x
        if (leftoverX > 0) {
            for (int j = 0; j < fullTilesY; j++) {
                float xStart = x1 + fullTilesX;// * tileSize;
                float xEnd = xStart + leftoverX;
                float yStart = y1 + j;// * tileSize;
                float yEnd = yStart + tileSize;
                float u0 = sprite.getMinU();
                float v0 = sprite.getMinV();
                float u1 = sprite.getFrameU(leftoverX);
                float v1 = sprite.getFrameV(tileSize);
                drawReversedQuad(vertexConsumer, entry, xStart, yStart, z1, xEnd, yEnd, z2, u0, v0, u1, v1, color, light, overlay, nx, ny, nz);
            }
        }

        // Draw leftover tiles in y
        if (leftoverY > 0) {
            for (int i = 0; i < fullTilesX; i++) {
                float xStart = x1 + i;// * tileSize;
                float xEnd = xStart + tileSize;
                float yStart = y1 + fullTilesY;// * tileSize;
                float yEnd = yStart + leftoverY;
                float u0 = sprite.getMinU();
                float v0 = sprite.getMinV();
                float u1 = sprite.getFrameU(tileSize);
                float v1 = sprite.getFrameV(leftoverY);
                drawReversedQuad(vertexConsumer, entry, xStart, yStart, z1, xEnd, yEnd, z2, u0, v0, u1, v1, color, light, overlay, nx, ny, nz);
            }

            // Draw the corner leftover tile if both leftoverX and leftoverY > 0
            if (leftoverX > 0) {
                float xStart = x1 + fullTilesX;// * tileSize;
                float xEnd = xStart + leftoverX;
                float yStart = y1 + fullTilesY;// * tileSize;
                float yEnd = yStart + leftoverY;
                float u0 = sprite.getMinU();
                float v0 = sprite.getMinV();
                float u1 = sprite.getFrameU(leftoverX);
                float v1 = sprite.getFrameV(leftoverY);
                drawReversedQuad(vertexConsumer, entry, xStart, yStart, z1, xEnd, yEnd, z2, u0, v0, u1, v1, color, light, overlay, nx, ny, nz);
            }
        }
    }

    private static void drawReversedTiledYZQuad(VertexConsumer vertexConsumer,
                                                MatrixStack.Entry entry,
                                                float x, float y1, float z1,
                                                float y2, float z2,
                                                Sprite sprite,
                                                int color,
                                                int light, int overlay,
                                                float nx, float ny, float nz) {
        float tileSize = 1.0f;
        int fullTilesZ = (int) ((z2 - z1));// / tileSize);
        int fullTilesY = (int) ((y2 - y1));// / tileSize);
        float leftoverZ = (z2 - z1) - (fullTilesZ);// * tileSize);
        float leftoverY = (y2 - y1) - (fullTilesY);// * tileSize);

        // Draw full tiles
        for (int i = 0; i < fullTilesZ; i++) {
            for (int j = 0; j < fullTilesY; j++) {
                float zStart = z1 + i;// * tileSize;
                float zEnd = zStart + tileSize;
                float yStart = y1 + j;// * tileSize;
                float yEnd = yStart + tileSize;
                float u0 = sprite.getMinU();
                float v0 = sprite.getMinV();
                float u1 = sprite.getMaxU();
                float v1 = sprite.getMaxV();
                drawReversedQuad(vertexConsumer, entry, x, yStart, zStart, x, yEnd, zEnd, u0, v0, u1, v1, color, light, overlay, nx, ny, nz);
            }
        }

        // Draw leftover tiles in z
        if (leftoverZ > 0) {
            for (int j = 0; j < fullTilesY; j++) {
                float zStart = z1 + fullTilesZ;// * tileSize;
                float zEnd = zStart + leftoverZ;
                float yStart = y1 + j;// * tileSize;
                float yEnd = yStart + tileSize;
                float u0 = sprite.getMinU();
                float v0 = sprite.getMinV();
                float u1 = sprite.getFrameU(leftoverZ);
                float v1 = sprite.getFrameV(tileSize);
                drawReversedQuad(vertexConsumer, entry, x, yStart, zStart, x, yEnd, zEnd, u0, v0, u1, v1, color, light, overlay, nx, ny, nz);
            }
        }

        // Draw leftover tiles in y
        if (leftoverY > 0) {
            for (int i = 0; i < fullTilesZ; i++) {
                float zStart = z1 + i;// * tileSize;
                float zEnd = zStart + tileSize;
                float yStart = y1 + fullTilesY;// * tileSize;
                float yEnd = yStart + leftoverY;
                float u0 = sprite.getMinU();
                float v0 = sprite.getMinV();
                float u1 = sprite.getFrameU(tileSize);
                float v1 = sprite.getFrameV(leftoverY);
                drawReversedQuad(vertexConsumer, entry, x, yStart, zStart, x, yEnd, zEnd, u0, v0, u1, v1, color, light, overlay, nx, ny, nz);
            }

            // Draw the corner leftover tile if both leftoverZ and leftoverY > 0
            if (leftoverZ > 0) {
                float zStart = z1 + fullTilesZ;// * tileSize;
                float zEnd = zStart + leftoverZ;
                float yStart = y1 + fullTilesY;// * tileSize;
                float yEnd = yStart + leftoverY;
                float u0 = sprite.getMinU();
                float v0 = sprite.getMinV();
                float u1 = sprite.getFrameU(leftoverZ);
                float v1 = sprite.getFrameV(leftoverY);
                drawReversedQuad(vertexConsumer, entry, x, yStart, zStart, x, yEnd, zEnd, u0, v0, u1, v1, color, light, overlay, nx, ny, nz);
            }
        }
    }
}