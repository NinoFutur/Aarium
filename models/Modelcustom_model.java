// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.12
// Paste this class into your mod and generate all required imports

public static class Modelcustom_model extends ModelBase {
	private final ModelRenderer bb_main;
	private final ModelRenderer Rightarm_r1;

	public Modelcustom_model() {
		textureWidth = 16;
		textureHeight = 16;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, 1.0F, -3.0F, -1.0F, 2, 3, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -3.0F, -3.0F, -1.0F, 2, 3, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -3.0F, -10.0F, -2.0F, 6, 7, 4, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -2.0F, -14.0F, -2.0F, 4, 4, 4, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, 3.0F, -9.0F, 0.0F, 1, 5, 1, 0.0F, false));

		Rightarm_r1 = new ModelRenderer(this);
		Rightarm_r1.setRotationPoint(-3.0F, 0.0F, -3.0F);
		bb_main.addChild(Rightarm_r1);
		setRotationAngle(Rightarm_r1, 0.0F, -1.5708F, 0.0F);
		Rightarm_r1.cubeList.add(new ModelBox(Rightarm_r1, 0, 0, 3.0F, -9.0F, 0.0F, 1, 5, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bb_main.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}