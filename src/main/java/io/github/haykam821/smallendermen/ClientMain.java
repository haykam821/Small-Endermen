package io.github.haykam821.smallendermen;

import io.github.haykam821.smallendermen.entity.render.SmallEndermanEntityModel;
import io.github.haykam821.smallendermen.entity.render.SmallEndermanEntityRenderer;
import io.github.haykam821.smallendermen.entity.render.TinyEndermanEntityModel;
import io.github.haykam821.smallendermen.entity.render.TinyEndermanEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class ClientMain implements ClientModInitializer {
	public static final EntityModelLayer SMALL_ENDERMAN_MODEL_LAYER = new EntityModelLayer(Main.SMALL_ENDERMAN_ID, "main");
	public static final EntityModelLayer TINY_ENDERMAN_MODEL_LAYER = new EntityModelLayer(Main.TINY_ENDERMAN_ID, "main");

	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.INSTANCE.register(Main.SMALL_ENDERMAN, SmallEndermanEntityRenderer::new);
		EntityRendererRegistry.INSTANCE.register(Main.TINY_ENDERMAN, TinyEndermanEntityRenderer::new);

		EntityModelLayerRegistry.registerModelLayer(SMALL_ENDERMAN_MODEL_LAYER, SmallEndermanEntityModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(TINY_ENDERMAN_MODEL_LAYER, TinyEndermanEntityModel::getTexturedModelData);
	}
}