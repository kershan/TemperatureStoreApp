package online.platformer.temperaturestoreapp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import online.platformer.temperaturestoreapp.R
import online.platformer.temperaturestoreapp.databinding.DashboardFragmentBinding
import online.platformer.temperaturestoreapp.domain.dashboard.DashboardViewModel
import org.koin.android.ext.android.inject

class DashboardFragment : Fragment() {

    private var _binding: DashboardFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DashboardViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DashboardFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.latestTemperature.observe(viewLifecycleOwner) {
            binding.latestTemp.text = getString(R.string.latest_temp, it)
        }

        viewModel.latestHumidity.observe(viewLifecycleOwner) {
            binding.latestHumidity.text = getString(R.string.latest_humidity, it)
        }

        viewModel.topTemperature.observe(viewLifecycleOwner) {
            binding.topTemp.text = getString(R.string.top_temp, it)
        }

        viewModel.topHumidity.observe(viewLifecycleOwner) {
            binding.topHumidity.text = getString(R.string.top_humidity, it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun newInstance() = DashboardFragment()
    }

}