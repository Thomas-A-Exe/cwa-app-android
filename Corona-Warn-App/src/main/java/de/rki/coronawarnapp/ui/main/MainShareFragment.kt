package de.rki.coronawarnapp.ui.main

import android.os.Bundle
import android.view.View
import android.view.accessibility.AccessibilityEvent
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import de.rki.coronawarnapp.R
import de.rki.coronawarnapp.databinding.FragmentMainShareBinding
import de.rki.coronawarnapp.ui.viewmodel.TracingViewModel
import de.rki.coronawarnapp.util.ExternalActionHelper
import de.rki.coronawarnapp.util.ui.viewBindingLazy

/**
 * This fragment informs the user about what he is going to share and how he is going to help everybody with this :)
 *
 * @see TracingViewModel
 */
class MainShareFragment : Fragment(R.layout.fragment_main_share) {

    private val tracingViewModel: TracingViewModel by activityViewModels()
    private val binding: FragmentMainShareBinding by viewBindingLazy()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tracingViewModel = tracingViewModel
        setButtonOnClickListener()
    }

    private fun setButtonOnClickListener() {
        binding.mainShareButton.setOnClickListener {
            ExternalActionHelper.shareText(this, getString(R.string.main_share_message), null)
        }
        binding.mainShareHeader.headerButtonBack.buttonIcon.setOnClickListener {
            (activity as MainActivity).goBack()
        }
    }

    override fun onResume() {
        super.onResume()
        binding.mainShareContainer.sendAccessibilityEvent(AccessibilityEvent.TYPE_ANNOUNCEMENT)
    }
}
