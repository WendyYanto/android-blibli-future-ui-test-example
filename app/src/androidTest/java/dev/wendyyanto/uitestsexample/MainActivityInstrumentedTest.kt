package dev.wendyyanto.uitestsexample

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.EnumSet.allOf


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
        onView(withId(R.id.et_name)).apply {
            check(matches(withHint("Insert Your Name")))
            check(matches(withText("")))
            check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        }
    }

    @Test
    fun whenFirstLaunchThenPageShouldHaveInitialEmptyPasswordAndHasValidHint() {
        onView(withId(R.id.et_password)).apply {
            check(matches(withHint("Insert Your Password")))
            check(matches(withText("")))
            check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        }
    }

    @Test
    fun whenFirstLaunchThenPageShouldHaveEnabledSubmitButton() {
        onView(withId(R.id.b_submit)).apply {
            check(matches(withText("Submit")))
            check(matches(isEnabled()))
        }
    }

    @Test
    fun whenFirstLaunchThenSuccessMessageShouldBeHidden() {
        onView(withId(R.id.tv_success_message)).apply {
            check(matches(withEffectiveVisibility(Visibility.GONE)))
        }
    }

    @Test
    fun whenTypeNameAndSubmitThenToastEmptyPasswordIsShown() {
        onView(withId(R.id.et_name)).perform(typeText("name"))
        onView(withId(R.id.b_submit)).perform(click())

//        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText("My text")))
//            .check(matches(isDisplayed()));
    }
}