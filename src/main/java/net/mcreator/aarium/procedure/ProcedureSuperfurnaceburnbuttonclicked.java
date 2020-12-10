package net.mcreator.aarium.procedure;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.Container;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.Entity;

import net.mcreator.aarium.item.ItemVolcaniteingot;
import net.mcreator.aarium.item.ItemLightiumGem;
import net.mcreator.aarium.item.ItemIthenariumingot;
import net.mcreator.aarium.item.ItemDarkiumingot;
import net.mcreator.aarium.item.ItemAariumingot;
import net.mcreator.aarium.block.BlockVolcaniteore;
import net.mcreator.aarium.block.BlockLightiumOre;
import net.mcreator.aarium.block.BlockIthenariumore;
import net.mcreator.aarium.block.BlockDarkiumore;
import net.mcreator.aarium.block.BlockAariumore;
import net.mcreator.aarium.ElementsAariumMod;

import java.util.function.Supplier;
import java.util.Map;

@ElementsAariumMod.ModElement.Tag
public class ProcedureSuperfurnaceburnbuttonclicked extends ElementsAariumMod.ModElement {
	public ProcedureSuperfurnaceburnbuttonclicked(ElementsAariumMod instance) {
		super(instance, 319);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Superfurnaceburnbuttonclicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double Slot0 = 0;
		boolean Burnable = false;
		Slot0 = (double) (new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof EntityPlayerMP) {
					Container _current = ((EntityPlayerMP) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
							if (stack != null)
								return stack.getCount();
						}
					}
				}
				return 0;
			}
		}.getAmount((int) (0)));
		if (((new Object() {
			public ItemStack getItemStack(int sltid) {
				if (entity instanceof EntityPlayerMP) {
					Container _current = ((EntityPlayerMP) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							return ((Slot) ((Map) invobj).get(sltid)).getStack();
						}
					}
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack((int) (0))).getItem() == new ItemStack(BlockAariumore.block, (int) (1)).getItem())) {
			if (entity instanceof EntityPlayerMP) {
				Container _current = ((EntityPlayerMP) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(ItemAariumingot.block, (int) (1));
						_setstack.setCount((int)Slot0);
						((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
			if (entity instanceof EntityPlayerMP) {
				Container _current = ((EntityPlayerMP) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
						_current.detectAndSendChanges();
					}
				}
			}
		} else {
			if (((new Object() {
				public ItemStack getItemStack(int sltid) {
					if (entity instanceof EntityPlayerMP) {
						Container _current = ((EntityPlayerMP) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (0))).getItem() == new ItemStack(BlockDarkiumore.block, (int) (1)).getItem())) {
				if (entity instanceof EntityPlayerMP) {
					Container _current = ((EntityPlayerMP) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(ItemDarkiumingot.block, (int) (1));
							_setstack.setCount((int)Slot0);
							((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof EntityPlayerMP) {
					Container _current = ((EntityPlayerMP) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
							_current.detectAndSendChanges();
						}
					}
				}
			} else {
				if (((new Object() {
					public ItemStack getItemStack(int sltid) {
						if (entity instanceof EntityPlayerMP) {
							Container _current = ((EntityPlayerMP) entity).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									return ((Slot) ((Map) invobj).get(sltid)).getStack();
								}
							}
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) (0))).getItem() == new ItemStack(BlockIthenariumore.block, (int) (1)).getItem())) {
					if (entity instanceof EntityPlayerMP) {
						Container _current = ((EntityPlayerMP) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(ItemIthenariumingot.block, (int) (1));
								_setstack.setCount((int)Slot0);
								((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
					if (entity instanceof EntityPlayerMP) {
						Container _current = ((EntityPlayerMP) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
								_current.detectAndSendChanges();
							}
						}
					}
				} else {
					if (((new Object() {
						public ItemStack getItemStack(int sltid) {
							if (entity instanceof EntityPlayerMP) {
								Container _current = ((EntityPlayerMP) entity).openContainer;
								if (_current instanceof Supplier) {
									Object invobj = ((Supplier) _current).get();
									if (invobj instanceof Map) {
										return ((Slot) ((Map) invobj).get(sltid)).getStack();
									}
								}
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack((int) (0))).getItem() == new ItemStack(Blocks.COAL_ORE, (int) (1)).getItem())) {
						if (entity instanceof EntityPlayerMP) {
							Container _current = ((EntityPlayerMP) entity).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									ItemStack _setstack = new ItemStack(Items.COAL, (int) (1), 0);
									_setstack.setCount((int)Slot0);
									((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
									_current.detectAndSendChanges();
								}
							}
						}
						if (entity instanceof EntityPlayerMP) {
							Container _current = ((EntityPlayerMP) entity).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
									_current.detectAndSendChanges();
								}
							}
						}
					} else {
						if (((new Object() {
							public ItemStack getItemStack(int sltid) {
								if (entity instanceof EntityPlayerMP) {
									Container _current = ((EntityPlayerMP) entity).openContainer;
									if (_current instanceof Supplier) {
										Object invobj = ((Supplier) _current).get();
										if (invobj instanceof Map) {
											return ((Slot) ((Map) invobj).get(sltid)).getStack();
										}
									}
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack((int) (0))).getItem() == new ItemStack(Blocks.IRON_ORE, (int) (1)).getItem())) {
							if (entity instanceof EntityPlayerMP) {
								Container _current = ((EntityPlayerMP) entity).openContainer;
								if (_current instanceof Supplier) {
									Object invobj = ((Supplier) _current).get();
									if (invobj instanceof Map) {
										ItemStack _setstack = new ItemStack(Items.IRON_INGOT, (int) (1));
										_setstack.setCount((int)Slot0);
										((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
										_current.detectAndSendChanges();
									}
								}
							}
							if (entity instanceof EntityPlayerMP) {
								Container _current = ((EntityPlayerMP) entity).openContainer;
								if (_current instanceof Supplier) {
									Object invobj = ((Supplier) _current).get();
									if (invobj instanceof Map) {
										((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
										_current.detectAndSendChanges();
									}
								}
							}
						} else {
							if (((new Object() {
								public ItemStack getItemStack(int sltid) {
									if (entity instanceof EntityPlayerMP) {
										Container _current = ((EntityPlayerMP) entity).openContainer;
										if (_current instanceof Supplier) {
											Object invobj = ((Supplier) _current).get();
											if (invobj instanceof Map) {
												return ((Slot) ((Map) invobj).get(sltid)).getStack();
											}
										}
									}
									return ItemStack.EMPTY;
								}
							}.getItemStack((int) (0))).getItem() == new ItemStack(Blocks.REDSTONE_ORE, (int) (1)).getItem())) {
								if (entity instanceof EntityPlayerMP) {
									Container _current = ((EntityPlayerMP) entity).openContainer;
									if (_current instanceof Supplier) {
										Object invobj = ((Supplier) _current).get();
										if (invobj instanceof Map) {
											ItemStack _setstack = new ItemStack(Items.REDSTONE, (int) (1));
											_setstack.setCount((int)Slot0);
											((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
											_current.detectAndSendChanges();
										}
									}
								}
								if (entity instanceof EntityPlayerMP) {
									Container _current = ((EntityPlayerMP) entity).openContainer;
									if (_current instanceof Supplier) {
										Object invobj = ((Supplier) _current).get();
										if (invobj instanceof Map) {
											((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
											_current.detectAndSendChanges();
										}
									}
								}
							} else {
								if (((new Object() {
									public ItemStack getItemStack(int sltid) {
										if (entity instanceof EntityPlayerMP) {
											Container _current = ((EntityPlayerMP) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													return ((Slot) ((Map) invobj).get(sltid)).getStack();
												}
											}
										}
										return ItemStack.EMPTY;
									}
								}.getItemStack((int) (0))).getItem() == new ItemStack(Blocks.GOLD_ORE, (int) (1)).getItem())) {
									if (entity instanceof EntityPlayerMP) {
										Container _current = ((EntityPlayerMP) entity).openContainer;
										if (_current instanceof Supplier) {
											Object invobj = ((Supplier) _current).get();
											if (invobj instanceof Map) {
												ItemStack _setstack = new ItemStack(Items.GOLD_INGOT, (int) (1));
												_setstack.setCount((int)Slot0);
												((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
												_current.detectAndSendChanges();
											}
										}
									}
									if (entity instanceof EntityPlayerMP) {
										Container _current = ((EntityPlayerMP) entity).openContainer;
										if (_current instanceof Supplier) {
											Object invobj = ((Supplier) _current).get();
											if (invobj instanceof Map) {
												((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
												_current.detectAndSendChanges();
											}
										}
									}
								} else {
									if (((new Object() {
										public ItemStack getItemStack(int sltid) {
											if (entity instanceof EntityPlayerMP) {
												Container _current = ((EntityPlayerMP) entity).openContainer;
												if (_current instanceof Supplier) {
													Object invobj = ((Supplier) _current).get();
													if (invobj instanceof Map) {
														return ((Slot) ((Map) invobj).get(sltid)).getStack();
													}
												}
											}
											return ItemStack.EMPTY;
										}
									}.getItemStack((int) (0))).getItem() == new ItemStack(Blocks.LAPIS_ORE, (int) (1)).getItem())) {
										if (entity instanceof EntityPlayerMP) {
											Container _current = ((EntityPlayerMP) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													ItemStack _setstack = new ItemStack(Items.DYE, (int) (1), 4);
													_setstack.setCount((int)Slot0);
													((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
													_current.detectAndSendChanges();
												}
											}
										}
										if (entity instanceof EntityPlayerMP) {
											Container _current = ((EntityPlayerMP) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
													_current.detectAndSendChanges();
												}
											}
										}
									} else {
										if (((new Object() {
											public ItemStack getItemStack(int sltid) {
												if (entity instanceof EntityPlayerMP) {
													Container _current = ((EntityPlayerMP) entity).openContainer;
													if (_current instanceof Supplier) {
														Object invobj = ((Supplier) _current).get();
														if (invobj instanceof Map) {
															return ((Slot) ((Map) invobj).get(sltid)).getStack();
														}
													}
												}
												return ItemStack.EMPTY;
											}
										}.getItemStack((int) (0))).getItem() == new ItemStack(Blocks.DIAMOND_ORE, (int) (1)).getItem())) {
											if (entity instanceof EntityPlayerMP) {
												Container _current = ((EntityPlayerMP) entity).openContainer;
												if (_current instanceof Supplier) {
													Object invobj = ((Supplier) _current).get();
													if (invobj instanceof Map) {
														ItemStack _setstack = new ItemStack(Items.DIAMOND, (int) (1));
														_setstack.setCount((int)Slot0);
														((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
														_current.detectAndSendChanges();
													}
												}
											}
											if (entity instanceof EntityPlayerMP) {
												Container _current = ((EntityPlayerMP) entity).openContainer;
												if (_current instanceof Supplier) {
													Object invobj = ((Supplier) _current).get();
													if (invobj instanceof Map) {
														((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
														_current.detectAndSendChanges();
													}
												}
											}
										} else {
											if (((new Object() {
												public ItemStack getItemStack(int sltid) {
													if (entity instanceof EntityPlayerMP) {
														Container _current = ((EntityPlayerMP) entity).openContainer;
														if (_current instanceof Supplier) {
															Object invobj = ((Supplier) _current).get();
															if (invobj instanceof Map) {
																return ((Slot) ((Map) invobj).get(sltid)).getStack();
															}
														}
													}
													return ItemStack.EMPTY;
												}
											}.getItemStack((int) (0))).getItem() == new ItemStack(Blocks.EMERALD_ORE, (int) (1)).getItem())) {
												if (entity instanceof EntityPlayerMP) {
													Container _current = ((EntityPlayerMP) entity).openContainer;
													if (_current instanceof Supplier) {
														Object invobj = ((Supplier) _current).get();
														if (invobj instanceof Map) {
															ItemStack _setstack = new ItemStack(Items.EMERALD, (int) (1));
															_setstack.setCount((int)Slot0);
															((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
															_current.detectAndSendChanges();
														}
													}
												}
												if (entity instanceof EntityPlayerMP) {
													Container _current = ((EntityPlayerMP) entity).openContainer;
													if (_current instanceof Supplier) {
														Object invobj = ((Supplier) _current).get();
														if (invobj instanceof Map) {
															((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
															_current.detectAndSendChanges();
														}
													}
												}
											} else {
												if (((new Object() {
													public ItemStack getItemStack(int sltid) {
														if (entity instanceof EntityPlayerMP) {
															Container _current = ((EntityPlayerMP) entity).openContainer;
															if (_current instanceof Supplier) {
																Object invobj = ((Supplier) _current).get();
																if (invobj instanceof Map) {
																	return ((Slot) ((Map) invobj).get(sltid)).getStack();
																}
															}
														}
														return ItemStack.EMPTY;
													}
												}.getItemStack((int) (0))).getItem() == new ItemStack(Blocks.QUARTZ_ORE, (int) (1)).getItem())) {
													if (entity instanceof EntityPlayerMP) {
														Container _current = ((EntityPlayerMP) entity).openContainer;
														if (_current instanceof Supplier) {
															Object invobj = ((Supplier) _current).get();
															if (invobj instanceof Map) {
																ItemStack _setstack = new ItemStack(Items.QUARTZ, (int) (1));
																_setstack.setCount((int)Slot0);
																((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
																_current.detectAndSendChanges();
															}
														}
													}
													if (entity instanceof EntityPlayerMP) {
														Container _current = ((EntityPlayerMP) entity).openContainer;
														if (_current instanceof Supplier) {
															Object invobj = ((Supplier) _current).get();
															if (invobj instanceof Map) {
																((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
																_current.detectAndSendChanges();
															}
														}
													}
												} else {
													if (((new Object() {
														public ItemStack getItemStack(int sltid) {
															if (entity instanceof EntityPlayerMP) {
																Container _current = ((EntityPlayerMP) entity).openContainer;
																if (_current instanceof Supplier) {
																	Object invobj = ((Supplier) _current).get();
																	if (invobj instanceof Map) {
																		return ((Slot) ((Map) invobj).get(sltid)).getStack();
																	}
																}
															}
															return ItemStack.EMPTY;
														}
													}.getItemStack((int) (0))).getItem() == new ItemStack(BlockLightiumOre.block, (int) (1))
															.getItem())) {
														if (entity instanceof EntityPlayerMP) {
															Container _current = ((EntityPlayerMP) entity).openContainer;
															if (_current instanceof Supplier) {
																Object invobj = ((Supplier) _current).get();
																if (invobj instanceof Map) {
																	ItemStack _setstack = new ItemStack(ItemLightiumGem.block, (int) (1));
																	_setstack.setCount((int)Slot0);
																	((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
																	_current.detectAndSendChanges();
																}
															}
														}
														if (entity instanceof EntityPlayerMP) {
															Container _current = ((EntityPlayerMP) entity).openContainer;
															if (_current instanceof Supplier) {
																Object invobj = ((Supplier) _current).get();
																if (invobj instanceof Map) {
																	((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
																	_current.detectAndSendChanges();
																}
															}
														}
													} else {
														if (((new Object() {
															public ItemStack getItemStack(int sltid) {
																if (entity instanceof EntityPlayerMP) {
																	Container _current = ((EntityPlayerMP) entity).openContainer;
																	if (_current instanceof Supplier) {
																		Object invobj = ((Supplier) _current).get();
																		if (invobj instanceof Map) {
																			return ((Slot) ((Map) invobj).get(sltid)).getStack();
																		}
																	}
																}
																return ItemStack.EMPTY;
															}
														}.getItemStack((int) (0))).getItem() == new ItemStack(BlockVolcaniteore.block, (int) (1))
																.getItem())) {
															if (entity instanceof EntityPlayerMP) {
																Container _current = ((EntityPlayerMP) entity).openContainer;
																if (_current instanceof Supplier) {
																	Object invobj = ((Supplier) _current).get();
																	if (invobj instanceof Map) {
																		ItemStack _setstack = new ItemStack(ItemVolcaniteingot.block, (int) (1));
																		_setstack.setCount((int)Slot0);
																		((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
																		_current.detectAndSendChanges();
																	}
																}
															}
															if (entity instanceof EntityPlayerMP) {
																Container _current = ((EntityPlayerMP) entity).openContainer;
																if (_current instanceof Supplier) {
																	Object invobj = ((Supplier) _current).get();
																	if (invobj instanceof Map) {
																		((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
																		_current.detectAndSendChanges();
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
