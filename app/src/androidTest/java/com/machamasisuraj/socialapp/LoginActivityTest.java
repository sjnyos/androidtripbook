package com.machamasisuraj.socialapp;

import android.content.ComponentName;
import android.content.Context;
import android.widget.Toast;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import com.machamasisuraj.socialapp.GUI.BottomNavbarActivity;
import com.machamasisuraj.socialapp.GUI.LoginActivity;
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
import static androidx.test.espresso.matcher.ViewMatchers.hasFocus;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginActivityTest {

   @Rule
    public ActivityTestRule<LoginActivity>
    testRule = new ActivityTestRule<>(LoginActivity.class);
        @Test
    public void CheckBadInputValidation(){
            onView(withId(R.id.etUsername))
                    .perform(typeText("@#$%^&*"),closeSoftKeyboard());

            onView(withId(R.id.etPassword))
                    .perform(typeText("@#$%&*()"),closeSoftKeyboard());

            onView(withId(R.id.btnLogin))
                    .perform(click());
        }

       @Test
        public void CheckLogin(){
            onView(withId(R.id.etUsername))
                    .perform(typeText("suraj1"),closeSoftKeyboard());

            onView(withId(R.id.etPassword))
                    .perform(typeText("suraj"),closeSoftKeyboard());

            onView(withId(R.id.btnLogin))
                    .perform(click());
           intended(hasComponent(new ComponentName(getTargetContext(), BottomNavbarActivity.class)));
           // intended(hasComponent(BottomNavbarActivity.class.getName()));
        }



}
