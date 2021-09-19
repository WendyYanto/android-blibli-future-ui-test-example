package dev.wendyyanto.uitestsexample

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    @get:Rule
    var activityRule = ActivityScenarioRule(
        MainActivity::class.java
    )

    @Test
    fun whenFirstLaunchThenPageShouldHaveValidTitle() {
        // ToDo: Implement UI test
    }

    @Test
    fun whenFirstLaunchThenPageShouldHaveInitialEmptyNameAndHasValidHint() {
        // ToDo: Implement UI test
    }

    @Test
    fun whenFirstLaunchThenPageShouldHaveInitialEmptyPasswordAndHasValidHint() {
        // ToDo: Implement UI test
    }

    @Test
    fun whenFirstLaunchThenPageShouldHaveEnabledSubmitButton() {
        // ToDo: Implement UI test
    }

    @Test
    fun whenFirstLaunchThenSuccessMessageShouldBeHidden() {
        // ToDo: Implement UI test
    }

    @Test
    fun whenSubmitImmediatelyThenEmptyNameErrorIsShown() {
        // ToDo: Implement UI test
    }

    @Test
    fun whenTypeNameOnlyAndSubmitThenEmptyPasswordErrorIsShown() {
        // ToDo: Implement UI test
    }

    @Test
    fun whenTypePasswordOnlyAndSubmitThenToastEmptyNameErrorIsShown() {
        // ToDo: Implement UI test
    }

    @Test
    fun whenTypePasswordAndNameAndSubmitThenSuccessBehaviorIsValid() {
        // ToDo: Implement UI test
    }
}