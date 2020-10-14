package io.github.haykam821.smallendermen.entity.render;

import net.minecraft.client.render.entity.EndermanEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;

public class TinyEndermanEntityRenderer extends EndermanEntityRenderer {
	public TinyEndermanEntityRenderer(EntityRenderDispatcher dispatcher) {
		super(dispatcher);
		this.model = new TinyEndermanEntityModel<>();
	}
}