package ws.wolfsoft.signup.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ws.wolfsoft.signup.Activity.ConseilTime;
import ws.wolfsoft.signup.Activity.ForTest;
import ws.wolfsoft.signup.PrefConfig;
import ws.wolfsoft.signup.R;
import ws.wolfsoft.signup.Retrofit.ApiClient;
import ws.wolfsoft.signup.Retrofit.ApiInterface;
import ws.wolfsoft.signup.Storage.ShardPrefManager;
import ws.wolfsoft.signup.User;

public class TimeFragment extends Fragment {


    public static ApiInterface apiInterface;
    public static PrefConfig prefConfig;
    String M,Mm,T,Tt,W,Ww,Tu,Ttu,F,Ff,S,Ss,deux,Nm;
    TextView m,mm,t,tt,w,ww,tu,ttu,f,ff,s,ss,tareh;
    int sm,smh,smm,am,amh,amm,nmh,nmd;
    int st,sth,stm,at,ath,atm,nth,ntd;
    int sw,swh,swm,aw,awh,awm,nwh,nwd;
    int stu,stuh,stum,atu,atuh,atum,ntuh,ntud;
    int sf,sfh,sfm,af,afh,afm,nfh,nfd;
    int sos,ssh,ssm,as,ash,asm,nsh,nsd;
    Button next;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {



        return inflater.inflate(R.layout.fragment_aff_time,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        prefConfig = new PrefConfig(getActivity());
        m = view.findViewById(R.id.m);
        mm = view.findViewById(R.id.mm);
        t = view.findViewById(R.id.t);
        tt = view.findViewById(R.id.tt);
        w = view.findViewById(R.id.w);
        tu = view.findViewById(R.id.tu);
        ww = view.findViewById(R.id.ww);
        ttu = view.findViewById(R.id.ttu);
        f = view.findViewById(R.id.f);
        ff = view.findViewById(R.id.ff);
        s = view.findViewById(R.id.s);
        ss = view.findViewById(R.id.ss);
        tareh = view.findViewById(R.id.tareh);
        next=view.findViewById(R.id.next);
        performRegistration();
    }
    public void performRegistration(){


        ws.wolfsoft.signup.models.User user = ShardPrefManager.getInstance(getActivity()).getUser();
        int Userid =user.getId();
        Call<User> call= apiInterface.information(Userid);
        call.enqueue(new Callback<User>() {
            Response<User> mts;
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                // prefConfig.displayToast("Registration sucess ... ");
                Log.e("response",response.body().getResponse());
                if(!response.body().getResponse().equals("failed")){
                if(response.body().getMts()!=null && response.body().getMte()!=null) {
                    if (!response.body().getMts().substring(0, 1).equals("0") && !response.body().getMts().substring(0, 1).equals("1") && !response.body().getMts().substring(0, 1).equals("2")) {
                        M = response.body().getMts().substring(0, 1) + "h" + response.body().getMts().substring(1);
                        smh = Integer.parseInt(response.body().getMts().substring(0, 1));
                        smm = Integer.parseInt(response.body().getMts().substring(1));
                        sm = smh * 60 + smm;
                    } else {
                        M = response.body().getMts().substring(0, 2) + "h" + response.body().getMts().substring(2);
                        smh = Integer.parseInt(response.body().getMts().substring(0, 2));
                        smm = Integer.parseInt(response.body().getMts().substring(2));
                        sm = smh * 60 + smm;
                    }

                    m.setText(M);


                    Mm = response.body().getMte().substring(0, 2) + "h" + response.body().getMte().substring(2);
                    amh = Integer.parseInt(response.body().getMte().substring(0, 2));
                    amm = Integer.parseInt(response.body().getMte().substring(2));
                    am = amh * 60 + amm;
                    nmh = (am - sm) / 60;
                    nmd = (am - sm) % 60;

                    mm.setText(Mm);
                }
                if(!response.body().getTts().equals("") && !response.body().getTte().equals("")) {
                    if (!response.body().getTts().substring(0, 1).equals("0") && !response.body().getTts().substring(0, 1).equals("1") && !response.body().getTts().substring(0, 1).equals("2")) {
                        T = response.body().getTts().substring(0, 1) + "h" + response.body().getTts().substring(1);
                        sth = Integer.parseInt(response.body().getTts().substring(0, 1));
                        stm = Integer.parseInt(response.body().getTts().substring(1));
                        st = sth * 60 + stm;
                    } else {
                        T = response.body().getTts().substring(0, 2) + "h" + response.body().getTts().substring(2);
                        sth = Integer.parseInt(response.body().getTts().substring(0, 2));
                        stm = Integer.parseInt(response.body().getTts().substring(2));
                        st = sth * 60 + stm;
                    }

                    t.setText(T);
                    Tt = response.body().getTte().substring(0, 2) + "h" + response.body().getTte().substring(2);
                    ath = Integer.parseInt(response.body().getTte().substring(0, 2));
                    atm = Integer.parseInt(response.body().getTte().substring(2));
                    at = ath * 60 + atm;
                    nth = (at - st) / 60;
                    ntd = (at - st) % 60;

                    tt.setText(Tt);
                }
                if(!response.body().getWts().equals("") && !response.body().getWte().equals("")) {
                    if (!response.body().getWts().substring(0, 1).equals("0") && !response.body().getWts().substring(0, 1).equals("1") && !response.body().getWts().substring(0, 1).equals("2")) {
                        W = response.body().getWts().substring(0, 1) + "h" + response.body().getWts().substring(1);
                        swh = Integer.parseInt(response.body().getWts().substring(0, 1));
                        swm = Integer.parseInt(response.body().getWts().substring(1));
                        sw = swh * 60 + swm;
                    } else {
                        W = response.body().getWts().substring(0, 2) + "h" + response.body().getWts().substring(2);
                        swh = Integer.parseInt(response.body().getWts().substring(0, 2));
                        swm = Integer.parseInt(response.body().getWts().substring(2));
                        sw = swh * 60 + swm;
                    }

                    w.setText(W);
                    Ww = response.body().getWte().substring(0, 2) + "h" + response.body().getWte().substring(2);
                    awh = Integer.parseInt(response.body().getWte().substring(0, 2));
                    awm = Integer.parseInt(response.body().getWte().substring(2));
                    aw = awh * 60 + awm;
                    nwh = (aw - sw) / 60;
                    nwd = (aw - sw) % 60;

                    ww.setText(Ww);
                }
                if(!response.body().getFts().equals("") && !response.body().getFte().equals("")) {
                    if (!response.body().getFts().substring(0, 1).equals("0") && !response.body().getFts().substring(0, 1).equals("1") && !response.body().getFts().substring(0, 1).equals("2")) {
                        Tu = response.body().getFts().substring(0, 1) + "h" + response.body().getFts().substring(1);
                        stuh = Integer.parseInt(response.body().getFts().substring(0, 1));
                        stum = Integer.parseInt(response.body().getFts().substring(1));
                        stu = stuh * 60 + stum;
                    } else {
                        Tu = response.body().getFts().substring(0, 2) + "h" + response.body().getFts().substring(2);
                        stuh = Integer.parseInt(response.body().getFts().substring(0, 2));
                        stum = Integer.parseInt(response.body().getFts().substring(2));
                        stu = stuh * 60 + stum;
                    }

                    tu.setText(Tu);
                    Ttu = response.body().getFte().substring(0, 2) + "h" + response.body().getFte().substring(2);
                    atuh = Integer.parseInt(response.body().getFte().substring(0, 2));
                    atum = Integer.parseInt(response.body().getFte().substring(2));
                    atu = atuh * 60 + atum;
                    ntuh = (atu - stu) / 60;
                    ntud = (atu - stu) % 60;

                    ttu.setText(Ttu);
                }
                if(!response.body().getThts().equals("") && !response.body().getThte().equals("")) {
                    if (!response.body().getThts().substring(0, 1).equals("0") && !response.body().getThts().substring(0, 1).equals("1") && !response.body().getThts().substring(0, 1).equals("2")) {
                        F = response.body().getThts().substring(0, 1) + "h" + response.body().getThts().substring(1);
                        sfh = Integer.parseInt(response.body().getThts().substring(0, 1));
                        sfm = Integer.parseInt(response.body().getThts().substring(1));
                        sf = sfh * 60 + sfm;
                    } else {
                        F = response.body().getThts().substring(0, 2) + "h" + response.body().getThts().substring(2);
                        sfh = Integer.parseInt(response.body().getThts().substring(0, 2));
                        sfm = Integer.parseInt(response.body().getThts().substring(2));
                        sf = sfh * 60 + sfm;
                    }

                    f.setText(F);
                    Ff = response.body().getThte().substring(0, 2) + "h" + response.body().getThte().substring(2);
                    afh = Integer.parseInt(response.body().getThte().substring(0, 2));
                    afm = Integer.parseInt(response.body().getThte().substring(2));
                    af = afh * 60 + afm;
                    nfh = (af - sf) / 60;
                    nfd = (af - sf) % 60;

                    ff.setText(Ff);
                }
                if(!response.body().getSts().equals("") && !response.body().getSte().equals("")) {
                    if (!response.body().getSts().substring(0, 1).equals("0") && !response.body().getSts().substring(0, 1).equals("1") && !response.body().getSts().substring(0, 1).equals("2")) {
                        S = response.body().getSts().substring(0, 1) + "h" + response.body().getSts().substring(1);
                        ssh = Integer.parseInt(response.body().getSts().substring(0, 1));
                        ssm = Integer.parseInt(response.body().getSts().substring(1));
                        sos = ssh * 60 + ssm;
                    } else {
                        S = response.body().getSts().substring(0, 2) + "h" + response.body().getSts().substring(2);
                        ssh = Integer.parseInt(response.body().getSts().substring(0, 2));
                        ssm = Integer.parseInt(response.body().getSts().substring(2));
                        sos = ssh * 60 + ssm;
                    }

                    s.setText(S);
                    Ss = response.body().getSte().substring(0, 2) + "h" + response.body().getSte().substring(2);
                    ash = Integer.parseInt(response.body().getSte().substring(0, 2));
                    asm = Integer.parseInt(response.body().getSte().substring(2));
                    as = ash * 60 + asm;
                    nsh = (as - sos) / 60;
                    nsd = (as - sos) % 60;

                    ss.setText(Ss);
                }
                deux = M.substring(0,1);
                Nm=String.valueOf(nmh)+"h"+String.valueOf(nmd);
                tareh.setText(Nm);

                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(getActivity(), ConseilTime.class);

                        i.putExtra("1", nmh);
                        i.putExtra("2", nmd);
                        i.putExtra("a1", smh);
                        i.putExtra("a2", smm);
                        i.putExtra("aa1", amh);
                        i.putExtra("aa2", amm);


                        i.putExtra("3", nth);
                        i.putExtra("4", nth);
                        i.putExtra("b1", sth);
                        i.putExtra("b2", stm);
                        i.putExtra("bb1", ath);
                        i.putExtra("bb2", atm);



                        i.putExtra("5", nwh);
                        i.putExtra("6", nwh);
                        i.putExtra("c1", swh);
                        i.putExtra("c2", swm);
                        i.putExtra("cc1", awh);
                        i.putExtra("cc2", awm);


                        i.putExtra("7", ntuh);
                        i.putExtra("8", ntuh);
                        i.putExtra("d1", stuh);
                        i.putExtra("d2", stum);
                        i.putExtra("dd1", atuh);
                        i.putExtra("dd2", atum);


                        i.putExtra("9", nfh);
                        i.putExtra("10", nfh);
                        i.putExtra("e1", sfh);
                        i.putExtra("e2", sfm);
                        i.putExtra("ee1", afh);
                        i.putExtra("ee2", afm);


                        i.putExtra("11", nsh);
                        i.putExtra("12", nsh);
                        i.putExtra("f1", ssh);
                        i.putExtra("f2", ssm);
                        i.putExtra("ff1", ash);
                        i.putExtra("ff2", asm);
                        startActivity(i);
                    }
                });


            }}

            @Override
            public void onFailure(Call<User> call, Throwable t) {

                prefConfig.displayToast("Succe le");
                Log.e("ERRO", t.getMessage());


            }

        });

    }
}
