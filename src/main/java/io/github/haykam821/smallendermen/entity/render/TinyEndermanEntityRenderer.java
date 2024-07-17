package io.github.haykam821.smallendermen.entity.render;

import io.github.haykam821.smallendermen.ClientMain;
import net.minecraft.client.render.entity.EndermanEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;

public class TinyEndermanEntityRenderer extends EndermanEntityRenderer {
	public TinyEndermanEntityRenderer(EntityRendererFactory.Context context) {
		super(context);
		this.model = new TinyEndermanEntityModel<>(context.getPart(ClientMain.TINY_ENDERMAN_MODEL_LAYER));
	}
}