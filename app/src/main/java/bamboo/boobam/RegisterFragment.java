package bamboo.boobam;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {


    public RegisterFragment() {
        // Required empty public constructor
    }

//    Create Main Method


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


//        Create Toolbar
        createToolbar();


    }   //Main method

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (item.getItemId() == R.id.itemUplod) {

            uploadProcess();
        }
        return super.onOptionsItemSelected(item);
    }

    private void uploadProcess() {

//        Get Value From Editext
        EditText nameEditText = getView().findViewById(R.id.editName);
        EditText userEditText = getView().findViewById(R.id.edtUser);
        EditText passEditText = getView().findViewById(R.id.edtPasword);

//        Convert Edittext to String
        String name = nameEditText.getText().toString().trim();
        String user = userEditText.getText().toString().trim();
        String pass = passEditText.getText().toString().trim();

//        Check Space

        if (name.isEmpty() || user.isEmpty() || pass.isEmpty()) {
//            Have Space
            alert("Have Space");
        } else {
//            No Space

            try {

                String urlPHP = "http://androidthai.in.th/fff/addDatoApe.php";
                AddDataThread addDataThread = new AddDataThread(getActivity());
                addDataThread.execute(name, user, pass, urlPHP);
                String result = addDataThread.get();
                Log.d("4JuneV1", "result =" + result);

            } catch (Exception e) {
                e.printStackTrace();
            }



        }   //if
    }   // uploadProcess

    private void alert(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_grgister, menu);



    }

    private void createToolbar() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarRegister);


        ((MainActivity)getActivity()).setSupportActionBar(toolbar);

//        Set Title
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Register");
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle("Please Fill Every Blank");
//        Set Navigater
        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();

            }
        });
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

}   //Main Class
