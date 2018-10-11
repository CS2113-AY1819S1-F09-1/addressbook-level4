package seedu.address.logic.commands;

import java.util.function.Predicate;

import seedu.address.model.SearchHistoryManager;

/**
 * Finds and lists all persons in address book whose name contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public abstract class FindCommand extends Command {

    public static final String COMMAND_WORD = "find";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose names/tags contain any of "
            + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " alice bob charlie";

    protected Predicate getMostUpdatedPredicate(SearchHistoryManager manager, Predicate predicate) {
        Predicate updatedPredicate = manager.executeNewSearch(predicate);
        return updatedPredicate;
    }
}
