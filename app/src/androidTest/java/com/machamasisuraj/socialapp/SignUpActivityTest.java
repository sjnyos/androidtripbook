package com.machamasisuraj.socialapp;

import android.content.ComponentName;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import com.machamasisuraj.socialapp.GUI.LoginActivity;
import com.machamasisuraj.socialapp.GUI.MainActivity;
import com.machamasisuraj.socialapp.GUI.SignupActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.InstrumentationRegistry.getTargetContext;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class SignUpActivityTest {
    @Rule
    public IntentsTestRule<SignupActivity>
            testRule = new IntentsTestRule<>(SignupActivity.class);
    @Test
    public void CheckInputValidation(){
        onView(withId(R.id.etFirstName))
                .perform(typeText("suraj123"),closeSoftKeyboard());

        onView(withId(R.id.etLastName))
                .perform(typeText("lastname"),closeSoftKeyboard());

        onView(withId(R.id.etSignUpUsername))
                .perform(typeText("suraj123"),closeSoftKeyboard());
        onView(withId(R.id.etSignUpPassword))
                .perform(typeText("password"),closeSoftKeyboard());
        onView(withId(R.id.etConfirmPassword))
                .perform(typeText("password"),closeSoftKeyboard());
        onView(withId(R.id.btnSignup))
                .perform(click());
        intended(hasComponent(new ComponentName(getTargetContext(), LoginActivity.class)));


    }
    public IntentsTestRule<MainActivity> mActivityRule = new IntentsTestRule<>(
            MainActivity.class);

}
