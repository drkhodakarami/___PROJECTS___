package jiraiyah.jiregister.interfaces;

import net.minecraft.client.data.BlockStateVariantMap;
import net.minecraft.client.render.model.json.ModelVariantOperator;

public interface BlockStateModelGeneratorAccessor
{
    BlockStateVariantMap<ModelVariantOperator> getNorthDefaultHorizontalRotationOperations();
}