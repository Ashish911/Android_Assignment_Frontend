package com.example.onlinefoodportal;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class EditProfileInstrumentedTest {


    @Rule
    public ActivityTestRule<MainActivity> testRule = new ActivityTestRule<>(MainActivity.class);

    private String Email = "kkk@kkk.com";
    private String Password = "kkk";

    @Test
    public void LogoutUITest() throws InterruptedException {
        onView(withId(R.id.emailLF))
                .perform(typeText(Email));

        closeSoftKeyboard();

        onView(withId(R.id.passwordLF))
                .perform(typeText(Password));

        closeSoftKeyboard();

        onView(withId(R.id.signinLF)).perform(click());

        onView(withId(R.id.nav_Account)).perform(click());

        onView(withId(R.id.profilelayout)).perform(click());

        Thread.sleep(1000);

        onView(withId(R.id.etUpdatePhone)).perform(clearText());
        onView(withId(R.id.etUpdatePhone)).perform(typeText("125460000"));
        closeSoftKeyboard();

        onView(withId(R.id.btnUpdate)).perform(click());
    }
}
