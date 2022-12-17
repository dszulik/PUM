package com.example.studenthardlife

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class ListFragmentDirections private constructor() {
  public companion object {
    public fun toDetailFragment(): NavDirections = ActionOnlyNavDirections(R.id.to_detailFragment)
  }
}
