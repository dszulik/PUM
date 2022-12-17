package com.example.studenthardlife

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class DetailFragmentDirections private constructor() {
  public companion object {
    public fun toListFragment(): NavDirections = ActionOnlyNavDirections(R.id.to_listFragment)
  }
}
