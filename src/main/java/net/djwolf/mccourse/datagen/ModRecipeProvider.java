package net.djwolf.mccourse.datagen;

import net.djwolf.mccourse.MCCourseMod;
import net.djwolf.mccourse.block.ModBlocks;
import net.djwolf.mccourse.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> ALEXANDRITE_SMELTABLES = List.of(ModItems.RAW_ALEXANDRITE.get(),
            ModBlocks.ALEXANDRITE_ORE.get(),
            ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(),
            ModBlocks.NETHER_ALEXANDRITE_ORE.get(),
            ModBlocks.END_STONE_ALEXANDRITE_ORE.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ALEXANDRITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ALEXANDRITE.get())
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALEXANDRITE_STICK.get())
                .pattern("A")
                .pattern("A")
                .define('A', ModItems.ALEXANDRITE.get())
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALEXANDRITE_PICKAXE.get())
                .pattern("AAA")
                .pattern(" I ")
                .pattern(" I ")
                .define('A', ModItems.ALEXANDRITE.get())
                .define('I', ModItems.ALEXANDRITE_STICK.get())
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALEXANDRITE_AXE.get())
                .pattern("AA")
                .pattern("IA")
                .pattern("I ")
                .define('A', ModItems.ALEXANDRITE.get())
                .define('I', ModItems.ALEXANDRITE_STICK.get())
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALEXANDRITE_SHOVEL.get())
                .pattern("A")
                .pattern("I")
                .pattern("I")
                .define('A', ModItems.ALEXANDRITE.get())
                .define('I', ModItems.ALEXANDRITE_STICK.get())
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALEXANDRITE_HOE.get())
                .pattern("AA")
                .pattern(" I")
                .pattern(" I")
                .define('A', ModItems.ALEXANDRITE.get())
                .define('I', ModItems.ALEXANDRITE_STICK.get())
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALEXANDRITE_SWORD.get())
                .pattern("A")
                .pattern("A")
                .pattern("I")
                .define('A', ModItems.ALEXANDRITE.get())
                .define('I', ModItems.ALEXANDRITE_STICK.get())
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALEXANDRITE_PAXEL.get())
                .pattern("ABC")
                .pattern(" I ")
                .pattern(" I ")
                .define('A', ModItems.ALEXANDRITE_AXE.get())
                .define('B', ModItems.ALEXANDRITE_SHOVEL.get())
                .define('C', ModItems.ALEXANDRITE_PICKAXE.get())
                .define('I', ModItems.ALEXANDRITE_STICK.get())
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALEXANDRITE_HAMMER.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern(" I ")
                .define('A', ModItems.ALEXANDRITE.get())
                .define('I', ModItems.ALEXANDRITE_STICK.get())
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EXPLODE_STICK.get())
                .pattern("I")
                .pattern("A")
                .pattern("I")
                .define('A', Items.TNT)
                .define('I', Items.STICK)
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALEXANDRITE_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .define('A', ModItems.ALEXANDRITE.get())
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALEXANDRITE_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ALEXANDRITE.get())
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALEXANDRITE_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.ALEXANDRITE.get())
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALEXANDRITE_BOOTS.get())
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.ALEXANDRITE.get())
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALEXANDRITE_HORSE_ARMOR.get())
                .pattern("  A")
                .pattern("AAA")
                .pattern("A A")
                .define('A', ModItems.ALEXANDRITE.get())
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ALEXANDRITE_LAMP.get())
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', ModItems.ALEXANDRITE.get())
                .define('B', Items.GLOWSTONE)
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DATA_TABLET.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.IRON_INGOT)
                .define('B', Items.REDSTONE)
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);




        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 9)
                .requires(ModBlocks.ALEXANDRITE_BLOCK.get())
                .unlockedBy("has_alexandrite_block", inventoryTrigger(ItemPredicate.Builder
                        .item()
                        .of(ModBlocks.ALEXANDRITE_BLOCK.get()).build()))
                .save(pWriter);

        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.RAW_ALEXANDRITE.get(),
                RecipeCategory.MISC, ModBlocks.RAW_ALEXANDRITE_BLOCK.get(),
                "mccourse:raw_alexandrite", "alexandrite",
                "mccourse:raw_alexandrite_block", "alexandrite");
        oreSmelting(pWriter, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(),
                0.25f, 200, "alexandrite");
        oreBlasting(pWriter, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(),
                0.15f, 100, "alexandrite");

        slab(pWriter, RecipeCategory.MISC, ModBlocks.ALEXANDRITE_SLAB.get(), ModItems.ALEXANDRITE.get());
        stairs(pWriter, ModBlocks.ALEXANDRITE_STAIRS.get(), ModItems.ALEXANDRITE.get());

        stonecutterResultFromBase(pWriter, RecipeCategory.MISC, ModBlocks.ALEXANDRITE_STAIRS.get(), ModBlocks.ALEXANDRITE_BLOCK.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.MISC, ModBlocks.ALEXANDRITE_SLAB.get(), ModBlocks.ALEXANDRITE_BLOCK.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.MISC, ModBlocks.ALEXANDRITE_WALL.get(), ModBlocks.ALEXANDRITE_BLOCK.get());

        buttonBuilder(ModBlocks.ALEXANDRITE_BUTTON.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).unlockedBy("has_alexandrite", has(ModItems.ALEXANDRITE.get())).save(pWriter);
        pressurePlate(pWriter, ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get(), ModItems.ALEXANDRITE.get());

        fenceBuilder(ModBlocks.ALEXANDRITE_FENCE.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).unlockedBy("has_alexandrite", has(ModItems.ALEXANDRITE.get())).save(pWriter);
        fenceGateBuilder(ModBlocks.ALEXANDRITE_FENCE_GATE.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).unlockedBy("has_alexandrite", has(ModItems.ALEXANDRITE.get())).save(pWriter);
        wall(pWriter, RecipeCategory.MISC, ModBlocks.ALEXANDRITE_WALL.get(), ModItems.ALEXANDRITE.get());

        doorBuilder(ModBlocks.ALEXANDRITE_DOOR.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).unlockedBy("has_alexandrite", has(ModItems.ALEXANDRITE.get())).save(pWriter);
        trapdoorBuilder(ModBlocks.ALEXANDRITE_TRAPDOOR.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).unlockedBy("has_alexandrite", has(ModItems.ALEXANDRITE.get())).save(pWriter);





    }

    protected static RecipeBuilder fenceGateBuilder(ItemLike pFenceGate, Ingredient pMaterial) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pFenceGate).define('#', ModItems.ALEXANDRITE_STICK.get()).define('W', pMaterial).pattern("#W#").pattern("#W#");
    }

    protected static RecipeBuilder fenceBuilder(ItemLike pFence, Ingredient pMaterial) {
        int i = pFence == Blocks.NETHER_BRICK_FENCE ? 6 : 3;
        Item item = pFence == Blocks.NETHER_BRICK_FENCE ? Items.NETHER_BRICK : ModItems.ALEXANDRITE_STICK.get();
        return ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, pFence, i).define('W', pMaterial).define('#', item).pattern("W#W").pattern("W#W");
    }

    protected static void stonecutterResultFromBase(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeCategory pCategory, ItemLike pResult, ItemLike pMaterial) {
        stonecutterResultFromBase(pFinishedRecipeConsumer, pCategory, pResult, pMaterial, 1);
    }

    protected static void stonecutterResultFromBase(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeCategory pCategory, ItemLike pResult, ItemLike pMaterial, int pResultCount) {
        SingleItemRecipeBuilder var10000 = SingleItemRecipeBuilder.stonecutting(Ingredient.of(new ItemLike[]{pMaterial}), pCategory, pResult, pResultCount).unlockedBy(getHasName(pMaterial), has(pMaterial));
        String var10002 = getConversionRecipeName(pResult, pMaterial);
        var10000.save(pFinishedRecipeConsumer,MCCourseMod.MOD_ID + ":" + var10002 + "_stonecutting");
    }

    protected static void stairs(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pStairs, ItemLike pMaterial) {
        stairBuilder(pStairs, Ingredient.of(new ItemLike[]{pMaterial})).unlockedBy(getHasName(pMaterial), has(pMaterial)).save(pFinishedRecipeConsumer);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer,
                                      List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult
                                      ,float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory,
                pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory,
                pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer).group(pGroup).
                    unlockedBy(getHasName(itemlike), has(itemlike)).save(pFinishedRecipeConsumer,
                            MCCourseMod.MOD_ID + ":" + (pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
