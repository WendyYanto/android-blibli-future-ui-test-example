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
        onView(withId(R.id.tv_title)).check(
            matches(
                withText("Welcome to my App")
            )
        )
    }

    @Test
    fun whenFirstLaunchThenPageShouldHaveInitialEmptyNameAndHasValidHint() {
        onView(withId(R.id.et_name))
            .check(matches(withHint("Insert Your Name")))
            .check(matches(withText(Matchers.isEmptyString())))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    @Test
    fun whenFirstLaunchThenPageShouldHaveInitialEmptyPasswordAndHasValidHint() {
        onView(withId(R.id.et_password))
            .check(matches(withHint("Insert Your Password")))
            .check(matches(withText(Matchers.isEmptyString())))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    @Test
    fun whenFirstLaunchThenPageShouldHaveEnabledSubmitButton() {
        onView(withId(R.id.b_submit))
            .check(matches(withText("Submit")))
            .check(matches(isEnabled()))
    }

    @Test
    fun whenFirstLaunchThenSuccessMessageShouldBeHidden() {
        onView(withId(R.id.tv_success_message))
            .check(matches(withEffectiveVisibility(Visibility.GONE)))
    }

    @Test
    fun whenSubmitImmediatelyThenEmptyNameErrorIsShown() {
        onView(withId(R.id.b_submit)).perform(click())

        onView(withText("Name should not empty"))
            .check(matches(isDisplayed()))
            .check(matches(hasTextColor(R.color.white)))
    }

    @Test
    fun whenTypeNameOnlyAndSubmitThenEmptyPasswordErrorIsShown() {
        onView(withId(R.id.et_name)).perform(typeText("name"))
        onView(withId(R.id.b_submit)).perform(click())

        onView(withText("Password should not empty"))
            .check(matches(isDisplayed()))
            .check(matches(hasTextColor(R.color.white)))
    }

    @Test
    fun whenTypePasswordOnlyAndSubmitThenToastEmptyNameErrorIsShown() {
        onView(withId(R.id.et_password)).perform(typeText("password"))
        onView(withId(R.id.b_submit)).perform(click())

        onView(withText("Name should not empty"))
            .check(matches(isDisplayed()))
            .check(matches(hasTextColor(R.color.white)))
    }

    @Test
    fun whenTypePasswordAndNameAndSubmitThenSuccessBehaviorIsValid() {
        onView(withId(R.id.et_name)).perform(typeText("name"))
        onView(withId(R.id.et_password)).perform(typeText("password"))
        onView(withId(R.id.b_submit)).perform(click())

        onView(withText("PROCESSING"))
            .check(matches(isDisplayed()))
            .check(matches(hasTextColor(R.color.white)))
        onView(withId(R.id.b_submit))
            .check(matches(withText("Data submitted")))
            .check(matches(isNotEnabled()))
        onView(withId(R.id.et_name)).check(matches(withEffectiveVisibility(Visibility.GONE)))
        onView(withId(R.id.et_password)).check(matches(withEffectiveVisibility(Visibility.GONE)))
        onView(withId(R.id.tv_success_message)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }
}