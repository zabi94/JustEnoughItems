package mezz.jei.api.recipe;

import mezz.jei.api.IModRegistry;
import mezz.jei.api.IRecipeRegistry;

/**
 * An IRecipeHandler provides information about one Recipe Class.
 * <p>
 * Its main purpose is to tie recipe classes to an {@link IRecipeCategory}
 * and convert recipes to {@link IRecipeWrapper} with {@link #getRecipeWrapper(Object)}.
 * <p>
 * Plugins implement these to handle their recipes, and register them with {@link IModRegistry#addRecipeHandlers(IRecipeHandler[])}.
 * You can find the registered Recipe Handler for a recipe class with {@link IRecipeRegistry#getRecipeHandler(Class)}
 */
public interface IRecipeHandler<T> {

	/**
	 * Returns the class of the Recipe handled by this IRecipeHandler.
	 */
	Class<T> getRecipeClass();

	/**
	 * Returns this recipe's unique category id.
	 *
	 * @deprecated since 3.5.0. Use {@link #getRecipeCategoryUid(Object)}
	 */
	@Deprecated
	String getRecipeCategoryUid();

	/**
	 * Returns this recipe's unique category id.
	 *
	 * @see IRecipeCategory#getUid()
	 * @see VanillaRecipeCategoryUid
	 * @since 3.5.0
	 */
	String getRecipeCategoryUid(T recipe);

	/**
	 * Returns a recipe wrapper for the given recipe.
	 */
	IRecipeWrapper getRecipeWrapper(T recipe);

	/**
	 * Returns true if a recipe is valid and can be used.
	 */
	boolean isRecipeValid(T recipe);
}
