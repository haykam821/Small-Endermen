package io.github.haykam821.smallendermen.entity.render;

import net.minecraft.client.render.entity.EndermanEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;

public class SmallEndermanEntityRenderer extends EndermanEntityRenderer {
	public SmallEndermanEntityRenderer(EntityRenderDispatcher dispatcher) {
		super(dispatcher);
		this.model = new SmallEndermanEntityModel<>();
	}
}