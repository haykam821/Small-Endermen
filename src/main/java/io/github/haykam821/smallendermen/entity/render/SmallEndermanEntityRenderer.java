package io.github.haykam821.smallendermen.entity.render;

import io.github.haykam821.smallendermen.ClientMain;
import net.minecraft.client.render.entity.EndermanEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;

public class SmallEndermanEntityRenderer extends EndermanEntityRenderer {
	public SmallEndermanEntityRenderer(EntityRendererFactory.Context context) {
		super(context);
		this.model = new SmallEndermanEntityModel<>(context.getPart(ClientMain.SMALL_ENDERMAN_MODEL_LAYER));
	}
}