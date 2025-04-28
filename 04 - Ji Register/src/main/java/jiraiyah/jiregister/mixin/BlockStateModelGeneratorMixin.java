package jiraiyah.jiregister.mixin;

import jiraiyah.jiregister.interfaces.BlockStateModelGeneratorAccessor;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.BlockStateVariantMap;
import net.minecraft.client.render.model.json.ModelVariantOperator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BlockStateModelGenerator.class)
public class BlockStateModelGeneratorMixin implements BlockStateModelGeneratorAccessor
{
    @Shadow
    private static BlockStateVariantMap<ModelVariantOperator> NORTH_DEFAULT_HORIZONTAL_ROTATION_OPERATIONS;

    @Override
    public BlockStateVariantMap<ModelVariantOperator> getNorthDefaultHorizontalRotationOperations()
    {
        return NORTH_DEFAULT_HORIZONTAL_ROTATION_OPERATIONS;
    }
}