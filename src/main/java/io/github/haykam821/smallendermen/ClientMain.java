package io.github.haykam821.smallendermen;

import io.github.haykam821.smallendermen.entity.render.SmallEndermanEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

public class ClientMain implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.INSTANCE.register(Main.SMALL_ENDERMAN, (dispatcher, context) -> {
			return new SmallEndermanEntityRenderer(dispatcher);
		});
	}
}